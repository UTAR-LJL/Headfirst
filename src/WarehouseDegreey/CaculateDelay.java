package WarehouseDegreey;

public class CaculateDelay {
	int orderSum, stackSum;
	Task [][] stackSchedule;
	int [] cntSchedule;
	double [] orderDelay;
	double totalDelay;
	public CaculateDelay(Task [][] sS, int [] cS, int orderS, int stackS) {
		// TODO Auto-generated constructor stub
		stackSchedule = sS;
		cntSchedule = cS;
		orderSum = orderS;
		stackSum = stackS;
		orderDelay = new double [orderSum + 1];
	}

	
	
	void ptSchedule() {
		System.out.println("orderId     retrieavalTime   ");
		for(int i = 0; i < stackSum; i ++) {
			for(int j = 0; j < cntSchedule[i]; j ++) {
				Task temp = stackSchedule[i][j];
				System.out.print(temp.orderId + "   " + temp.retrievalTime + "   " + temp.waitingTime + "  ");
			}
			System.out.println("");
		}
	}
	
	
	
	void ptDelay() {
		//System.out.println("orderDelay: ");
		//System.out.println("");
		System.out.println("totalDelay:  " + totalDelay);
		//System.out.println("\n\n");
		
	}
	
	void caculate() {
		for(int i = 0; i < stackSum; i ++) {
			for(int j = 0; j < cntSchedule[i]; j ++) {
				Task temp = stackSchedule[i][j];
				int id = temp.orderId;
				orderDelay[id] = Math.max(orderDelay[id], temp.retrievalTime + temp.waitingTime);
				
			}
		}
		
		totalDelay = 0;
		for(int i = 1; i <= orderSum; i ++) {
			totalDelay += orderDelay[i];
			//System.out.print(orderDelay[i] + "   ");
		}
		
	}
	
}
