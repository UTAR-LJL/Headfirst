package WarehouseDegreey;

import java.util.ArrayList;
import java.util.Random;

public class CreateData {
	// Assume that retrieval time of each task is between 5  and 20
	// itemSum of each order is between 1 and 10;
	int orderSum, stackSum;  //order index start from 1; stack and other index start from 0;
	int [] orderStart;  //record first item's index of each order in taskSet;
	int [] orderItemsSum; //record how many items of each order after merging;
	ArrayList<Task> taskSet = new ArrayList<Task>(); //record all the tasks ;
	int[] orderArrivalTime;
	public CreateData(int os, int ss) {
		// TODO Auto-generated constructor stub
		orderSum = os;
		stackSum = ss;
		orderStart = new int[orderSum + 1];
		orderItemsSum = new int[orderSum + 1];
		orderArrivalTime = new int[orderSum + 1];
	}
	
	
	void createTaskSet() {
		//System.out.println("orderId  " + "stackId  " + "retrievalTime  ");
		int current = 0;
		int time = 0;
		for(int i = 1; i <= orderSum; i ++) {
			int itemSum = (int)(1 + Math.random()*10 );
			int realSum = 0;
			double z = Math.random();
			double x = -(20) * Math.log(z);
			time += x;
			orderArrivalTime[i] = (int)time;
			for(int j = 1; j <= itemSum; j ++) {
				Task t = new Task();
				t.orderId = i;
				t.stackId = (int)(Math.random()*stackSum );
				t.retrievalTime = 5 + (int)(Math.random()*26);
				t.arrivalTime = (int)time;
				
				boolean flag = true;							  // current stores the start index of items belong to an order
				for(int k = current; k < taskSet.size(); k ++) {  //if two items belong to same order allocated to same stack
					Task temp = taskSet.get(k);					  //temp refer to the item which already been added to taskSet,
					if(temp.orderId == t.orderId && temp.stackId == t.stackId) { // each time traverse items belong to same order,
						temp.retrievalTime += t.retrievalTime;					 // to find whether the new item is allocated to same stacker.
						flag = false;
						break;
					}
				}
				if(flag == true) {
					taskSet.add(t);
					realSum ++;
				}
				// 1 1 1 2 2 2 2 2 3 3 3		
				//System.out.println(t.orderId + "  " + t.stackId + "  " + t.retrievalTime + "  ");
			}
			orderStart[i] = current;
			orderItemsSum[i] = realSum;
			current += realSum;
		}		
	}
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//orderSum; itemSum (1 - 10); retrievalTime (5 - 20); 
		//stackSum; stackIndex (1 - stackSum); 
		//Random.seed(3)
		CreateData c = new CreateData(100, 15);
		c.createTaskSet();
		System.out.println("orderId  " + "stackId  " + "retrievalTime  ");
		for(int i = 0; i < c.taskSet.size(); i ++) {
			Task t = c.taskSet.get(i);  
			System.out.println(t.orderId + "     " + t.stackId + "     " + t.retrievalTime + "    " + t.waitingTime + "     " + t. arrivalTime + "   " + t.finishTime);
		}
	}

}
