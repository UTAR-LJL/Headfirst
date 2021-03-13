package WarehouseDegreey;

public class TestGreedyThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinomialDistribution.setDis();
		
		int stackSum = 10, orderSum =20000;
		
		GreedyThree g3 = new GreedyThree(stackSum, orderSum);
		g3.threshold = 1000;
		GreedyOne g1 = new GreedyOne(stackSum, orderSum);
		g3.eventSimulation(70);
		
		System.out.println("totalDealy: "+GreedyThree.totalDelay + "  maxDelay:  "+GreedyThree.maxDelayOrder);

		System.out.println("g1 delay:  "+ GreedyOne.totalDelay +  "  average delay: " + GreedyOne.totalDelay / 20000);
		//delayG1 += GreedyOne.totalDelay;
		System.out.println("g1 maxdelay£º "+GreedyOne.maxDelayOrder);

		g3.printStackTask();
		
		System.out.println("max cnt: "+g3.calculatePressure()+" total packageTime: "+GreedyThree.totalPackageTime  + "  average: "+ GreedyThree.totalPackageTime/GreedyThree.allfinishTime);
		
		System.out.println("max cnt: "+GreedyOne.calculatePressure()+" total packageTime: "+GreedyOne.totalPackageTime  + "  average: "+ GreedyOne.totalPackageTime/GreedyOne.allfinishTime);

		
	}

}
