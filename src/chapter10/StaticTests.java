package chapter10;

public class StaticTests extends StaticSuper {
	static int rand;
	
	static {
		rand = (int) (Math.random() * 6);
		System.out.println("Static block" + rand);
	}
	
	StaticTests() {
		// TODO Auto-generated constructor stub
		System.out.println("constructor");
	}
	
	public static void main(String [] args) {
		System.out.println("in main");
		StaticTests st = new StaticTests();
	}
	
}
