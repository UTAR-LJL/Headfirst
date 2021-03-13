package WarehouseDegreey;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FixOT {
	static long totalDelay ;
	static int cnt;
	int orderSum, stackSum;
	static long totalPackageTime;
	static long allfinishTime;
	static long maxDelayOrder;
	ArrayList<Time> packageTime = new ArrayList<Time>();
	ArrayList<Order> order = new ArrayList<Order>();
	ArrayList<Stacker> stacker = new ArrayList<Stacker>();
	
	public FixOT(int stackSum,int orderSum) { 
		this.orderSum = orderSum;
		this.stackSum = stackSum;
		for (int i = 0; i < stackSum; i++) {
			Stacker s = new Stacker();
			stacker.add(s);
		}
	}
	
	void copy(Task a, Task b) {  //copy variables value from b
		//a = new Task();
		a.retrievalTime = b.retrievalTime;
		a.waitingTime = b.waitingTime;
		a.orderId = b.orderId;
		a.stackId = b.stackId;
		a.finishTime = b.finishTime;
		a.arrivalTime = b.arrivalTime;		
		
	}
	
	

	
	void delete(Task t,int startTime) { //删除order里面的task
		
		int id = t.orderId;
		int sid = t.stackId;
		for (int i = 0; i < order.size(); i++) {	
			if (order.get(i).orderId == id) {
				
				if (order.get(i).started == false) {
					order.get(i).started = true;
					order.get(i).startTime = startTime;
					packageTime.add(new Time(startTime, 1) );

				}
				order.get(i).task.remove(t);  // 有待检查\	
				
				if (order.get(i).task.size() == 0) {
					int k = order.get(i).orderTag - order.get(i).arrivalTime;
					FixOT.maxDelayOrder = Math.max(FixOT.maxDelayOrder, k);
					totalDelay += k;
					packageTime.add(new Time(order.get(i).orderTag, -1) );
					totalPackageTime += order.get(i).orderTag - order.get(i).startTime;
					order.remove(i);
				}
				break;
			}
					
		}
		stacker.get(sid).executedTask.add(t);
		//stacker.get(sid).scheduledTask.remove(t);
		
		
	}

	void process(Order newOrder) { //处理已经排好序的scheduledTask
		//printStackTask();
		
		int now = newOrder.arrivalTime;
		for (int i = 0; i < stackSum; i++) {
			for (int j = 0; j < stacker.get(i).scheduledTask.size(); j++) {
				Task temp = stacker.get(i).scheduledTask.get(j);
				if (stacker.get(i).realBusyTime <= now) {
					stacker.get(i).realBusyTime += temp.retrievalTime;
					delete(temp, stacker.get(i).realBusyTime); // 删除原来order里面相应的task
					stacker.get(i).scheduledTask.remove(j); //删除stacker.scheduled里面相应的task，
					j = j -1; //删除后 下标建议
				}
				else {
					break;
				}
			}
			if (stacker.get(i).realBusyTime < now) {
				stacker.get(i).realBusyTime = now;
			}
			//stacker.get(i).busyTime = stacker.get(i).realBusyTime;
			
		}

	}
	

	
	void printStackTask() {
		
		System.out.println("scheduled Task:");
		for (int i = 0; i < stackSum; i++) {
			System.out.print("stack"+i+"  ");
			for (int j = 0; j < stacker.get(i).scheduledTask.size(); j++) {
				System.out.print( stacker.get(i).scheduledTask.get(j).orderId+"  ");
			}
			System.out.println("");
		}

		System.out.println("executedTask: ");
		for (int i = 0; i < stackSum; i++) {
			System.out.print("stack"+i+"  ");
			for (int j = 0; j < stacker.get(i).executedTask.size(); j++) {
				System.out.print( stacker.get(i).executedTask.get(j).orderId+"  ");
				
			}
			System.out.println("");
		}

	}
	
	Order findOrder(int id) {
		for (int i = 0; i < order.size(); i++) {
			if (order.get(i).orderId == id) {
				return order.get(i);
			}
		}
		return null;
	}
	
	void schedule(Order newOrder) {
		   
		order.add(newOrder);
			
		int[] acc = new int[300000];
		Arrays.fill(acc, 0);
		for (int i = 0; i < newOrder.task.size(); i ++) {
			
			Task t = newOrder.task.get(i);
			acc[t.stackId] += t.retrievalTime;
			int time = stacker.get(t.stackId).realBusyTime + acc[t.stackId];
			newOrder.orderTag = Math.max(newOrder.orderTag, time);
		}
		
		//System.out.println("neworder orderTag: " + newOrder.orderTag);

		
		boolean flag;
		flag = true;
		for (int i = 0; i < newOrder.task.size(); i ++) {
			if (flag == false) {
				break;
			}
			Task t = newOrder.task.get(i);
			Order ot = findOrder(t.orderId);
			ArrayList<Task> p = stacker.get(t.stackId).scheduledTask;
			int j;
			int st = stacker.get(t.stackId).realBusyTime;
			
			for (j = 0; j < p.size(); j++) {
					Task t0 = p.get(j);
					Order ot0 = findOrder(t0.orderId); //从order里面找OrderTag
					if (ot0.orderTag <= ot.orderTag) {
						st += t0.retrievalTime;
					}
					else if (ot0.orderTag > ot.orderTag) {
						//p.add(j, t);
						t.pos = j;
						t.newTime = st + t.retrievalTime; // task t 在stacker里的完成时间
						int kt = st;
						for (int k = j; k < p.size(); k++) {
							Task t1 = p.get(k);
							Order ot1 = findOrder(t1.orderId);
							if (kt + t.retrievalTime + t1.retrievalTime > ot1.orderTag) {
								flag = false;
								cnt++;
								break;
								
							}
							kt += t1.retrievalTime;
							
						}										
					}
					if (flag == false) {
						break;
					}

				}
			if (j == p.size()) {
				t.pos = p.size();
				t.newTime = st;
			}
			if (flag == false) {
				break;
				
			}
		}
		
		if (flag == false) {
			for (int i = 0; i < newOrder.task.size(); i ++) {
				Task t = newOrder.task.get(i);
				Order ot = findOrder(t.orderId);
				//System.out.println("false: "+t);
				ArrayList<Task> p = stacker.get(t.stackId).scheduledTask;
				p.add(p.size(), t);
				Stacker s = stacker.get(t.stackId);
				s.busyTime = Math.max(s.busyTime, t.arrivalTime) + t.retrievalTime;
				
				ot.orderTag = Math.max(ot.orderTag, s.busyTime);
				
			}
			
		} else {
			for (int i = 0; i < newOrder.task.size(); i ++) {
				Task t = newOrder.task.get(i);
				Order ot = findOrder(t.orderId);
				//System.out.println("true  "+t);
				ArrayList<Task> p = stacker.get(t.stackId).scheduledTask;
				if (t.pos != p.size() ) {
					//System.out.println(t.pos + "  p.size() " + p.size());
					cnt++;
				}
				p.add(t.pos, t);
				
				Stacker s = stacker.get(t.stackId);
			
				s.busyTime = Math.max(s.busyTime, t.arrivalTime) + t.retrievalTime;
				
				ot.orderTag = Math.max(ot.orderTag, t.newTime);
				
			}
			
		}
		
		
		
		
	}
		
	
	void eventSimulation(int rate) {	
		
		for (int i = 0; i < orderSum; i++) {
			Order newOrder =new Order(i, stackSum, rate);
			Order n2 = new Order(newOrder);
			GreedyOne.process(newOrder);
			System.out.println("\n newOrder  " + n2);
			process(n2);
			//System.out.println("after process:");
			schedule(n2);
		}
		finish();
		
		
		
		Order.time = 0;
		Order. taskId = 0;
		
		Task.stackerTag = 0;
		

	}
	
	
	void finish() { //处理已经排好序的scheduledTask
		//printStackTask();
		allfinishTime = 0;
		for (int i = 0; i < stackSum; i++) {
			
			for (int j = 0; j < stacker.get(i).scheduledTask.size(); j++) {
				Task temp = stacker.get(i).scheduledTask.get(j);				
					stacker.get(i).realBusyTime += temp.retrievalTime;
					delete(temp, stacker.get(i).realBusyTime); // 删除stacker里面的，原来order里面的
					stacker.get(i).scheduledTask.remove(j);
					j = j - 1;
	
			}
			allfinishTime = Math.max(allfinishTime, stacker.get(i).realBusyTime);
			//stacker.get(i).busyTime = stacker.get(i).realBusyTime;
			
		}

	}
	
	int calculatePressure() {
		
		 Collections.sort(packageTime, new Comparator<Time>() {

	            @Override
	            public int compare(Time o1, Time o2) {
	                //升序排序，降序反写
	                return (int)(o1.w - o2.w);
	            }

	        });
		 
		 int cnt = 0;
		 int maxCnt = 0;
		 for (int i = 0; i < packageTime.size(); i++) {
			
			 if (packageTime.get(i).flag == 1) {
				 cnt ++;
				maxCnt = Math.max(maxCnt, cnt);
				
			} else {
				cnt --;
				maxCnt = Math.max(maxCnt, cnt);
				
			}
			 
		}
		 
		 return maxCnt;
		
	}

	
}

