package Algorithm4;

import java.util.Arrays;

public class ThreeSum {
	
	public static int count(int[] a) {
		int n = a.length, cnt = 0;
		Arrays.parallelSort(a);
		for(int i = 0; i < n; i ++)
			for(int j = i + 1; j < n; j ++)
			{
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				if (k > j) {
					cnt ++;
					System.out.println(a[i] + " " + a[j] + " " + a[k]);
				}
			}
		return cnt;
	}

}
