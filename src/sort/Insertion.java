package sort;

public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i ++) {
			for(int j = i; j > 0 && less(a[i],a[j]); j --)
				exch(a, j, j - 1);
			
		}
		
		
		
	}
	
	
}
