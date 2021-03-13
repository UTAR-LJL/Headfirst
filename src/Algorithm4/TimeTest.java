package Algorithm4;

import java.util.Random;
import java.util.Scanner;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		int[] a = new int[N];
		for(int i = 0; i < N; i ++) {
			a[i] = (int)(Math.random()*100 - 50);
			System.out.println(a[i]);
		}
		StopWatch timer = new StopWatch();
		int cnt = ThreeSum.count(a);
		System.out.println(cnt);
		double t = timer.elapsedTime();
		System.out.println(t);
	}

}
