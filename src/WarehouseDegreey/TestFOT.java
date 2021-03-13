package WarehouseDegreey;

public class TestFOT {
	
	public static void main(String[] args) {
		
		BinomialDistribution.setDis();
		
		int stackSum = 10, orderSum =2000;
		FixOT fot = new FixOT(stackSum, orderSum);
		GreedyOne g1 = new GreedyOne(stackSum, orderSum);
		
		fot.eventSimulation(140);
		
		System.out.println("totalDealy: "+FixOT.totalDelay + "  maxDelay:  "+FixOT.maxDelayOrder);
		System.out.println("false times: " + FixOT.cnt);
		System.out.println("g1 delay:  "+ GreedyOne.totalDelay +  "  average delay: " + GreedyOne.totalDelay / 2000);
		//delayG1 += GreedyOne.totalDelay;
		System.out.println("g1 maxdelay£º "+GreedyOne.maxDelayOrder);

		fot.printStackTask();
		
		System.out.println("max cnt: "+fot.calculatePressure()+" total packageTime: "+FixOT.totalPackageTime  + "  average: "+ FixOT.totalPackageTime/FixOT.allfinishTime);
		
		System.out.println("max cnt: "+GreedyOne.calculatePressure()+" total packageTime: "+GreedyOne.totalPackageTime  + "  average: "+ GreedyOne.totalPackageTime/GreedyOne.allfinishTime);

		
	}

}
