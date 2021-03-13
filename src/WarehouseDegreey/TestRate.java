package WarehouseDegreey;



public class TestRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinomialDistribution.setDis();
		
 
		int stackSum = 10, orderSum = 50000, rate;
		
		for (int i = 50; i <= 180; i+= 5) {
			System.out.println("I: "+ i);
			rate = i;
			
			GreedyOne g1 = new GreedyOne(stackSum, orderSum);
			GreedyTwo g2 = new GreedyTwo(stackSum, orderSum);
			//FixOT fot = new FixOT(stackSum, orderSum);
			
				for (int j = 0; j < orderSum; j++) {
					Order newOrder =new Order(j, stackSum, rate);
					Order n2 = new Order(newOrder);
					
					//System.out.println("\n newOrder  " + n2);
					
					g1.process(newOrder);
					
					g2.process(newOrder);
					g2.schedule(newOrder);
					
					//fot.process(n2);
					//fot.schedule(n2);
				}
				g2.finish();
				//fot.finish();
				
				System.out.println("g1 delay:  "+ GreedyOne.totalDelay +  "  average delay: " + GreedyOne.totalDelay / 50000 + "maxdelay£º "+GreedyOne.maxDelayOrder);
				System.out.println("max cnt: "+GreedyOne.calculatePressure()+" total packageTime: "+GreedyOne.totalPackageTime  + "  average: "+ GreedyOne.totalPackageTime/GreedyOne.allfinishTime);

				System.out.println("g2 delay:  "+ GreedyTwo.totalDelay + "  average delay: " + GreedyTwo.totalDelay / 50000 + "maxDelay:  "+ GreedyTwo.maxDelayOrder);
				System.out.println("max cnt: "+g2.calculatePressure()+" total packageTime: "+GreedyTwo.totalPackageTime  + "  average: "+ GreedyTwo.totalPackageTime/GreedyTwo.allfinishTime);

				//System.out.println("fot delay:  "+ FixOT.totalDelay +  "  average delay: " + FixOT.totalDelay / 20000 + "maxdelay£º "+FixOT.maxDelayOrder);				
				//System.out.println("max cnt: "+fot.calculatePressure()+" total packageTime: "+FixOT.totalPackageTime  + "  average: "+ FixOT.totalPackageTime/FixOT.allfinishTime);

				Order.time = 0;
				Order. taskId = 0;		
				Task.stackerTag = 0;
				
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
				

				
//				FixOT.totalDelay = 0;
//				FixOT.maxDelayOrder = 0;
//				FixOT.cnt = 0;
//				FixOT.allfinishTime = 0;
//				FixOT.totalPackageTime = 0;
				

		}
	
		
		
		 	   
	}

}
