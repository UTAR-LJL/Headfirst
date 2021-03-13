package WarehouseDegreey;

import java.util.ArrayList;

public class FIFO {
	ArrayList<Task> taskSet;
	int orderSum;
	int stackSum;
	int[] cntSchedule;
	double[] waitingTime;
	Task[][] stackSchedule;
	
	public FIFO(ArrayList<Task> ts,int os, int ss) { //os:orderSum; ss: stackSum;
		// TODO Auto-generated constructor stub
		orderSum = os;
		stackSum = ss;
		cntSchedule = new int[ss];
		taskSet = ts;
		stackSchedule = new Task[stackSum][];
		waitingTime = new double[stackSum];
		for(int i = 0; i < stackSum; i ++) {
			
			stackSchedule[i] = new Task[1000];
		}
	}
	
	void copy(Task a, Task b) {
		
		a.retrievalTime = b.retrievalTime;
		a.waitingTime = b.waitingTime;
		a.orderTag = b.orderTag;
		a.orderId = b.orderId;
		a.stackId = b.stackId;
		
	}
	
	void scheduling() {
		for (int i = 0; i < taskSet.size(); i++) {
			Task temp = taskSet.get(i);
			temp.waitingTime = 0;
			int j = temp.stackId;
			stackSchedule[j][cntSchedule[j] ] = new Task();
			copy(stackSchedule[j][cntSchedule[j] ] ,temp);
			stackSchedule[j][cntSchedule[j] ].waitingTime += waitingTime[j];
			waitingTime[j] += stackSchedule[j][cntSchedule[j] ].retrievalTime;
			//System.out.println("waitingTime " + waitingTime[j]);
			cntSchedule[j]  ++;
		}
		
		
		
	}
	
	
	
	
}
