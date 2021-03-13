package WarehouseDegreey;

public class BinomialDistribution {
	static double dis[] = new double[32];  //¼ÇÂ¼¸ÅÂÊÀÛ¼Æ
	public static double C(double n, double k) {
		double a=1,b=1;
		if(k>n/2) {
			k=n-k;
		}
		for(int i=1;i<=k;i++) {
			a*=(n+1-i);
			b*=i;
		}
		return a/b;
	}
	public static void setDis() {
		
		double p = 0.31;
		double q = 1 - p;
		int A = 30;
		
		for (int i = 1; i <= 30; i++) {
			//System.out.println("C:  "+C(A-1,i-1));
			double t = C(A-1,i-1)*Math.pow(p, i - 1)*Math.pow(q, A - i);
			dis[i] = t + dis[i-1];
			//System.out.println("dis: "+ dis[i]);
		}
		
//		for(double x: dis) {
//			System.out.println(x);
//		}
	}
	
	public static int getItemsSum(double y) {
		for (int i = 1; i < 30; i++) {
			if (dis[i] > y) {
				return i;		
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		BinomialDistribution.setDis();
		for (int i = 0; i < 100000; i++) {
			double y = Math.random();
			int sum = BinomialDistribution.getItemsSum(y);
			System.out.println(sum);
			if (sum == 25) {
				System.out.println("success");
				return;
			}
			
		}
	}

}
