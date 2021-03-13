package WarehouseDegreey;



public class TestG1G2G3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinomialDistribution.setDis();
		
 
		int stackSum = 10, orderSum = 100000, rate;
	for (int t = 70; t <=  70; t = t + 10) {
		
		rate = t;
		System.out.println("rate: "+rate +"\n");
		for (int i = 400; i <= 5000; i+= 600) {
			System.out.println("I: "+ i);
			
			GreedyThree.threshold = i;
			GreedyOne g1 = new GreedyOne(stackSum, orderSum);
			GreedyTwo g2 = new GreedyTwo(stackSum, orderSum);
			GreedyThree g3 = new GreedyThree(stackSum, orderSum);
			//System.out.println("threshold:  "+GreedyThree.threshold);

				for (int j = 0; j < orderSum; j++) {
					Order newOrder =new Order(j, stackSum, rate);
					Order n2 = new Order(newOrder);
					
					//System.out.println("\n newOrder  " + n2);
					
					g1.process(newOrder);
					
					g2.process(newOrder);
					g2.schedule(newOrder);
					
					g3.process(n2);
					g3.schedule(n2);
				}
				g2.finish();
				g3.finish();
				
				System.out.println("g1 delay:  "+ GreedyOne.totalDelay +  "  average delay: " + GreedyOne.totalDelay / 100000 + "maxdelay£º "+GreedyOne.maxDelayOrder);
				System.out.println("max cnt: "+GreedyOne.calculatePressure()+" total packageTime: "+GreedyOne.totalPackageTime  + "  average: "+ GreedyOne.totalPackageTime*1.0/100000);

				System.out.println("g2 delay:  "+ GreedyTwo.totalDelay + "  average delay: " + GreedyTwo.totalDelay / 100000 + "maxDelay:  "+ GreedyTwo.maxDelayOrder);
				System.out.println("max cnt: "+g2.calculatePressure()+" total packageTime: "+GreedyTwo.totalPackageTime  + "  average: "+ GreedyTwo.totalPackageTime*1.0/100000);

				System.out.println("g3 delay:  "+ GreedyThree.totalDelay +  "  average delay: " + GreedyThree.totalDelay / 100000 + "maxdelay£º "+GreedyThree.maxDelayOrder);				
				System.out.println("max cnt: "+g3.calculatePressure()+" total packageTime: "+GreedyThree.totalPackageTime  + "  average: "+ GreedyThree.totalPackageTime*1.0/100000);

				Order.time = 0;
				Order.taskId = 0;		
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
				
				GreedyThree.totalDelay = 0;
				GreedyThree.maxDelayOrder = 0;
				GreedyThree.allfinishTime = 0;
				GreedyThree.totalPackageTime = 0;
				

		}	 	   
	}
	}
}
