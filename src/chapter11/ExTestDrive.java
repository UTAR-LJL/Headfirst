package chapter11;

class MyEx extends Exception {};

public class ExTestDrive {
	static void doRisky(String t) throws MyEx{
		System.out.print("h");
		if(t.equals("yes") )
			throw new MyEx();
		System.out.print("a");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = args[0];
		try {
			doRisky(test);
			
		} catch (MyEx e) {
			System.out.print("ro");
			// TODO: handle exception
		} finally {
			System.out.print("ws");
		}
		
	}

}
