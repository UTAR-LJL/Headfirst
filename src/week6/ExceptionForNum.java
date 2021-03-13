package week6;

import java.io.IOException;
import java.util.Scanner;

public class ExceptionForNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner cin = new Scanner(System.in);
			
			System.out.print("Please input a number: ");
			String s = cin.next();		
			int n = Integer.parseInt(s);
		}
		
		catch(NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

}
