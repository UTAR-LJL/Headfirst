package chapter10;

import java.util.Calendar;

public class FullMoons {
	static int DAY_IM = 1000 * 60 * 60 * 24;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.set(2004, 0,7,15,40);
		long day1 = c.getTimeInMillis();
		day1 += (DAY_IM * 29.5);
		c.setTimeInMillis(day1);
		System.out.println(String.format("full moon on %tc", c.getTime()));
	}

}
