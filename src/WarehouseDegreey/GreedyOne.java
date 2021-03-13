package WarehouseDegreey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GreedyOne {
	static long totalDelay ;
	static long totalPackageTime;
	static long allfinishTime;

	int orderSum, stackSum;
	static long maxDelayOrder;
	static ArrayList<Stacker> stacker = new ArrayList<Stacker>();
	static ArrayList<Time> packageTime = new ArrayList<Time>();

	
	public GreedyOne(int stackSum,int orderSum) {
		// TODO Auto-generated constructor stub
		
		this.orderSum = orderSum;
		this.stackSum = stackSum;
		for (int i = 0; i < stackSum; i++) {
			Stacker s = new Stacker();
			stacker.add(s);
		}
		
	}
	public static void process(Order newOrder) {
		
		long delay = 0;
		long startTime = 1000000000;
		long finishtime = 0;
		for(int i = 0; i < newOrder.task.size(); i++) {
			Task t = newOrder.task.get(i);
			Stacker si = stacker.get(t.stackId);
			if (si.busyTime < newOrder.arrivalTime) {
				si.busyTime = newOrder.arrivalTime;	
			}
			si.busyTime += t.retrievalTime;
			startTime = Math.min(si.busyTime, startTime);
			
			finishtime = Math.max(finishtime, si.busyTime);
		}
		
		
		packageTime.add(new Time(startTime, 1));
		packageTime.add(new Time(finishtime, -1));
		totalPackageTime += finishtime - startTime;
		maxDelayOrder = Math.max(maxDelayOrder, finishtime - newOrder.arrivalTime);
		totalDelay += finishtime - newOrder.arrivalTime;
		
	}
	
	static int calculatePressure() {
		
		for (int i = 0; i < stacker.size(); i++) {
			Stacker si = stacker.get(i);

			allfinishTime = Math.max(allfinishTime, si.busyTime);
		}
		
		 Collections.sort(packageTime, new Comparator<Time>() {

	            @Override
	            public int compare(Time o1, Time o2) {
	                //…˝–Ú≈≈–Ú£¨Ωµ–Ú∑¥–¥
	                return (int)(o1.w - o2.w);
	            }

	        });
		 
		 int cnt = 0;
		 int maxCnt = 0;
		 //System.out.println(packageTime.size());
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
