package WarehouseDegreey;

import java.util.ArrayList;

public class Order {

	static int time;
	static int taskId;
	ArrayList<Task> task = new ArrayList<Task>();
	int orderTag, itemsSum, arrivalTime,orderId, waitingTime;
	long startTime;
	boolean started; 
	boolean visited;
	/*
	 * item 数量 1-30
	 * 订单 数量 180/h
	 */
	
	public Order (Order newOrder) {
		this.arrivalTime = newOrder.arrivalTime;
		this.itemsSum = newOrder.itemsSum;
		this.orderId = newOrder.orderId;
		this.orderTag = newOrder.orderTag;
		this.startTime = newOrder.startTime;
		
		for (int i = 0; i < newOrder.task.size(); i++) {
			Task nt = newOrder.task.get(i);
			Task t = new Task();
			t.retrievalTime = nt.retrievalTime;
			t.waitingTime = nt.waitingTime;
			t.taskId = nt.taskId;
			t.arrivalTime = nt.arrivalTime;
			t.orderId = nt.orderId;
			t.stackId = nt.stackId;
			t.finishTime = nt.finishTime;
			t.pos = nt.pos;
			this.task.add(t);
			
		}
		
		
		
	}
	public Order(int id, int stackSum,int rate) {
		// TODO Auto-generated constructor stub
		orderId = id;

		double pro = Math.random();
		itemsSum = BinomialDistribution.getItemsSum(pro); 
		
		double z = Math.random();
		//double x = -(20) * Math.log(z);  //180orders / hour
//		z = Math.random();
		double x = -(3600 / rate) * Math.log(z);
		time += x;
		arrivalTime = (int)time;
		for(int j = 1; j <= itemsSum; j ++) {
			Task t = new Task();
			t.taskId = taskId ++;
			t.orderId = id;
			t.stackId = (int)(Math.random()*stackSum );
			int p = (int)(Math.random()*20) + 1; // 1 - 10
			int q = (int)(Math.random()*39) + 2; // 2 - 20
			t.retrievalTime = 10 + Math.max(p/2, q/2) * 2; 
			t.arrivalTime = (int)time;
			task.add(t);
		}
		
	}
	
	@Override 
	public String toString() {
		return this.orderId + " + aTime: " + this.arrivalTime +" + items: "+this.itemsSum+" task: "+task.size();
	}
	
	public boolean equals(Order t) {
		// TODO Auto-generated method stub
		if (this == t) {
			return true;
		}
		
		if (t.orderId == this.orderId) {
			return true;
		}
		else 
			return false;
		
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.orderId;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			Order o = new Order(i, 5,180);
			System.out.println(o);
		}
	}


}
