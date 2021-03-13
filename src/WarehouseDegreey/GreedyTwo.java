package WarehouseDegreey;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GreedyTwo {
	static long totalDelay ;
	static long totalPackageTime;
	static long maxDelayOrder;
	static long allfinishTime;
	int orderSum, stackSum;
	ArrayList<Time> packageTime = new ArrayList<Time>();
	ArrayList<Order> order = new ArrayList<Order>();
	ArrayList<Stacker> stacker = new ArrayList<Stacker>();
	
	public GreedyTwo(int stackSum,int orderSum) { 
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
	
	

	
	void delete(Task t, int startTime) {
		
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
					GreedyTwo.maxDelayOrder = Math.max(GreedyTwo.maxDelayOrder, k);
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
				if (stacker.get(i).realBusyTime < now) {
					stacker.get(i).realBusyTime += temp.retrievalTime;
					delete(temp,stacker.get(i).realBusyTime); // 删除stacker里面的，原来order里面的
					
				}
				else {
					break;
				}
			}
			if (stacker.get(i).realBusyTime < now) {
				stacker.get(i).realBusyTime = now;
			}
			stacker.get(i).busyTime = stacker.get(i).realBusyTime;
			
		}
		//清空scheduledTask
		for (int i = 0; i < stackSum; i++) {
			stacker.get(i).scheduledTask.clear();
		}
		
	}
	
	// 订单内部或许需要排序
	void handle(Order mini) {
		for (int i = 0; i < mini.task.size(); i++) {
			Task t = mini.task.get(i);
			int stackerId = t.stackId;
			stacker.get(stackerId).busyTime += t.retrievalTime;
			stacker.get(stackerId).scheduledTask.add(t);
			stacker.get(stackerId).task.remove(t);
		}
		
	}
	
	void printStackTask() {
		
	
		System.out.println("\n task:");
		for (int i = 0; i < stackSum; i++) {
			System.out.print("stack"+i+"  ");
			for (int j = 0; j < stacker.get(i).task.size(); j++) {
				System.out.print( stacker.get(i).task.get(j).orderId+"  ");
			}
			System.out.println("");
		}

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
//			System.out.println("order: ");
//			for (int i = 0; i < order.size(); i++) {
//				Order o = order.get(i);
//				System.out.println(o+ "  ");
//				
//			}
//			System.out.println("");
			
			for (int i = 0; i < order.size(); i++) {  //清空 order里面订单的orderTag信息
				Order o = order.get(i);
				o.orderTag = 0;
				o.visited = false;
				
				for (int j = 0; j < o.task.size(); j++) {
					Task t = o.task.get(j);
					//findOrder(t.orderId).orderTag = 0;
					stacker.get(t.stackId).task.add(t);
				}
			}
		
		int[] acc = new int[300000];
		while(true) {

			int cnt = 0;
			for (int i = 0; i < stackSum; i++) {
				//stacker.get(i).busyTime = Math.max(stacker.get(i).busyTime, newOrder.arrivalTime);
				if (stacker.get(i).task.size() == 0) {
					cnt = cnt + 1;
					continue;
				}
				Arrays.fill(acc, 0);
				for (int j = 0; j < stacker.get(i).task.size(); j++) {
					Task temp = stacker.get(i).task.get(j);
					//temp.stackerTag += temp.retrievalTime;
					acc[temp.orderId] += temp.retrievalTime;
					//System.out.println(temp);
					findOrder(temp.orderId).orderTag = Math.max(stacker.get(i).busyTime + acc[temp.orderId], findOrder(temp.orderId).orderTag);			
					
				}
			}
			if (cnt == stackSum) {
				//System.out.println("final cnt  "+cnt);
				break;
			}
			//System.out.println("cnt "+cnt);
			
			int minimumTag = 100000000;
			Order mini = null;
			for (int i = 0; i < order.size(); i++) {
				if ( (order.get(i).visited == false) && (order.get(i).orderTag < minimumTag) ) {
					minimumTag = order.get(i).orderTag;
					mini = order.get(i);
				}
			}
			mini.visited = true;
		
			handle(mini) ;  //把order i 的 task 放入 相应stacker的scheduledTask 
		}  
	}
		
	
	void eventSimulation(int rate) {	
		
		for (int i = 0; i < orderSum; i++) {
			Order newOrder =new Order(i, stackSum, rate);
			//System.out.println(stackSum);
			//System.out.println(newOrder);
			GreedyOne.process(newOrder);
			//System.out.println("\n newOrder  " + newOrder);
			process(newOrder);
			//System.out.println("after process:");
			schedule(newOrder);
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
					delete(temp,stacker.get(i).realBusyTime); // 删除stacker里面的，原来order里面的
	
			}
			
			stacker.get(i).busyTime = stacker.get(i).realBusyTime;
			allfinishTime = Math.max(allfinishTime, stacker.get(i).realBusyTime);

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
