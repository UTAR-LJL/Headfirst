package WarehouseDegreey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedySimple {
	int orderSum, stackSum;
	int [] cnt;
	int [] cntSchedule;
	ArrayList<Task> taskSet;
	Task [][] stackTask;
	Task [][] stackSchedule ;
	
	public GreedySimple(ArrayList<Task> ts, int os, int ss) {
		// TODO Auto-generated constructor stub
		taskSet = ts;
		orderSum = os;
		stackSum = ss;
		stackTask = new Task[stackSum][];
		stackSchedule = new Task[stackSum][];
		cnt = new int[stackSum];
		
		cntSchedule = new int[stackSum];
		for(int i = 0; i < stackSum; i ++) {
			stackTask[i] = new Task[2000];
			stackSchedule[i] = new Task[2000];
		}
	}
	
	void copy(Task a, Task b) {
		
		a.retrievalTime = b.retrievalTime;
		a.waitingTime = b.waitingTime;
		a.orderTag = b.orderTag;
		a.orderId = b.orderId;
		a.stackId = b.stackId;
		
	}
	
	void initialize() {
		for(int i = 0; i < taskSet.size(); i ++) {
			Task temp = taskSet.get(i);
			int sId = temp.stackId;
			int index = cnt[sId] ++;
			stackSchedule[sId][index] = stackTask[sId][index] = new Task();
			copy(stackTask[sId][index],temp);
		}
		cntSchedule = cnt;
	}
	
	class RetrievalTimeCompare implements Comparator<Task> {
		public int compare(Task a, Task b) {
			if(Math.abs(a.retrievalTime - b.retrievalTime) < 1e-6 )
				return 0;
			else if(a.retrievalTime - b .retrievalTime > 0)
				return 1;
			else 
				return -1;
			
		}
		
	}
	
	void scheduling() {
		for(int i = 0; i < stackSum; i ++) {
			Arrays.sort(stackSchedule[i], 0, cntSchedule[i],new RetrievalTimeCompare());
			
		}
		
		
			/*System.out.println("GreedySimple  orderId     retrieavalTime   ");
			for(int i = 0; i < stackSum; i ++) {
				for(int j = 0; j < cntSchedule[i]; j ++) {
					Task temp = stackSchedule[i][j];
					System.out.print(temp.orderId + "   " + temp.retrievalTime + "   ");
				}
				System.out.println("");
			}*/
		
		
		for(int i = 0; i < stackSum; i ++) {
			double wt = 0;
			for(int j = 0; j < cntSchedule[i]; j ++) {
				Task temp = stackSchedule[i][j];
				temp.waitingTime = wt;
				wt += temp.retrievalTime;
			}		
		}

	}
	
	void ptTask() {
		System.out.println("  Stack Task");
		for(int i = 0; i < stackSum; i ++) {
			for (int j = 0; j < cnt[i]; j++) {
				Task temp = stackTask[i][j];
				System.out.print(temp.orderId + "   " + temp.retrievalTime + "   ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
