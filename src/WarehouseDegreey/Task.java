package WarehouseDegreey;

import java.util.Arrays;


public class Task implements Comparable<Task>{
	int retrievalTime, waitingTime,  taskId;
	int arrivalTime;
	int orderId, stackId;
	int finishTime;
	int newTime;
	int pos;
	static int stackerTag;
	
	@Override
	public int compareTo(Task t) {
		double eps = 1e-8;
		if (Math.abs(this.retrievalTime - t.retrievalTime) < eps) 
			return 0;
		/*else if(this.retrievalTime > t.retrievalTime)
			return 1;
		else 
			return -1;*/
		else
			return (int)(this.retrievalTime - t.retrievalTime);
		
	}
	
	@Override
	public String toString() {
		return "oId: "+orderId + " + rt: " + retrievalTime + " sId: "+stackId+" taskId: "+taskId;
	}
	
	public boolean equals(Task t) {
		// TODO Auto-generated method stub
		if (this == t) {
			return true;
		}
		
		if (t.taskId == this.taskId) {
			return true;
		}
		else 
			return false;
		
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.taskId;
	}
	
	public static void main(String[] args) {
		
	}
	
}
