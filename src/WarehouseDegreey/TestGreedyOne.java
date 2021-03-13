package WarehouseDegreey;

import java.util.ArrayList;

public class TestGreedyOne {
	static ArrayList<Double> a1 = new ArrayList<Double>();
	static ArrayList<Double> a2 = new ArrayList<Double>();
	static ArrayList<Double> c1 = new ArrayList<Double>();
	static ArrayList<Double> c2 = new ArrayList<Double>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 100; i <= 100; i += 100)
		{
			double averageG1Delay = 0;
			double averageGsDelay = 0;
			double averageG2Delay = 0;
			double averageFifoDelay = 0;
			for(int j = 1; j <= 1; j ++)
		{
		cnt ++;
		CreateData c = new CreateData(2000, 5);
		c.createTaskSet();
		System.out.println("orderId  " + "stackId  " + "retrievalTime  ");
		for(int p = 0; p < c.taskSet.size(); p ++) {
			Task t = c.taskSet.get(p);
			System.out.println(t.orderId + "  " + t.stackId + "  " + t.retrievalTime + "  " + t.waitingTime + "  " + t.arrivalTime);
		}
		
		/*
		GreedyOne g1 = new GreedyOne(c.taskSet, c.orderSum, c.stackSum);
		g1.initialize();
		//g1.ptTask();
		g1.scheduling();	
		CaculateDelay greedyOneDelay = new CaculateDelay(g1.stackSchedule, g1.cntSchedule, g1.orderSum, g1.stackSum);
		//greedyOneDelay.ptSchedule();
		greedyOneDelay.caculate();
		//greedyOneDelay.ptDelay();
		averageG1Delay += greedyOneDelay.totalDelay;
		
		GreedySimple gs = new GreedySimple(c.taskSet, c.orderSum, c.stackSum);
		gs.initialize();
		//gs.ptTask();
		gs.scheduling();		
		CaculateDelay greedySimpleDelay = new CaculateDelay(gs.stackSchedule, gs.cntSchedule, gs.orderSum, gs.stackSum);
		//greedySimpleDelay.ptSchedule();
		greedySimpleDelay.caculate();
		//greedySimpleDelay.ptDelay();
		averageGsDelay += greedySimpleDelay.totalDelay;
		
		*/
		GreedyTwo g2 = new GreedyTwo(c.taskSet, c.orderSum, c.stackSum, c.orderStart, c.orderItemsSum, c.orderArrivalTime);
		g2.eventSimulation();
		g2.ptTask();
		//CaculateDelay greedyTwoDelay = new CaculateDelay(g2.stackSchedule, g2.cntSchedule, g2.orderSum, g2.stackSum);
		//greedyTwoDelay.ptSchedule();
		//greedyTwoDelay.caculate();
		//greedyTwoDelay.ptDelay();
		//averageG2Delay += greedyTwoDelay.totalDelay;
		/*
		FIFO fifo = new FIFO(c.taskSet, c.orderSum, c.stackSum);
		fifo.scheduling();
		CaculateDelay FifoDelay = new CaculateDelay(fifo.stackSchedule, fifo.cntSchedule, fifo.orderSum, fifo.stackSum);
		FifoDelay.caculate();
		//ifoDelay.ptSchedule();
		//fifoDelay.ptDelay();
		averageFifoDelay += FifoDelay.totalDelay;
		*/
		
		c = null;
//		g1 = null;
//		greedyOneDelay = null;
		g2 = null;
//		greedyTwoDelay = null;
//		gs = null;
//		greedySimpleDelay = null;
//		fifo = null;
//		FifoDelay = null;
		
		}
//			averageG1Delay /= 500  ;
//			averageGsDelay /= 500  ;
//			averageG2Delay /=  500  ;
//			averageFifoDelay /= 500;
//			a1.add(averageG1Delay);
//			a2.add(averageG2Delay);
//			c1.add(averageGsDelay);
//			c2.add(averageFifoDelay);
//		
	}
//		
//	System.out.println("cnt : " + cnt);	
//		
//	for(Double item : a1)
//		System.out.print(item + "  ");
//	System.out.println("");
//	for(Double item : a2)
//		System.out.print(item + "  ");
//	System.out.println("");
//	for(Double item : c1)
//		System.out.print(item + "  ");
//	System.out.println("");
//	for(Double item : c2)
//		System.out.print(item + "  ");
//	System.out.println("");

	}

}
