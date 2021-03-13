package WarehouseDegreey;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinomialDistribution.setDis();
		

		int stackSum, orderSum = 10000;
		
		//GreedyOne g1 = new GreedyOne(stackSum, orderSum);

			
		for (int i = 20; i <= 100; i += 10) {
			for (int j = 6; j < 7; j += 2) {
				
			System.out.println(" order rate: " + i + " stackSum " + j);
			GreedyTwo g2 = new GreedyTwo(j, orderSum);
			GreedyOne g1 = new GreedyOne(j, orderSum);
			g2.eventSimulation(i);
			System.out.println(" g2 totaldelay:  " + GreedyTwo.totalDelay + "  average delay: " + GreedyTwo.totalDelay / 10000 + "maxDelay: " + GreedyTwo.maxDelayOrder);
			System.out.println(" g1 totaldelay:  " + GreedyOne.totalDelay + "  average delay: " + GreedyOne.totalDelay / 10000 + "maxdelay£º " + GreedyOne.maxDelayOrder);
			GreedyOne.totalDelay = 0;
			GreedyOne.maxDelayOrder = 0;
			GreedyOne.stacker.clear();
			GreedyOne.allfinishTime = 0;
			GreedyOne.totalPackageTime = 0;
			GreedyOne.packageTime.clear();
			
			GreedyTwo.totalDelay = 0;
			GreedyTwo.maxDelayOrder = 0;
			GreedyTwo.totalPackageTime = 0;
			GreedyTwo.allfinishTime = 0;	
			//System.out.println("max cnt: " + g2.calculatePressure()+" total packageTime: "+GreedyTwo.totalPackageTime  + "  average: "+ GreedyTwo.totalPackageTime/GreedyTwo.allfinishTime);
			
			}
		}
	}

}
