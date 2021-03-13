package HeadFirst;

public class Player {
	static int playerCount;
	static final double x;
	
	private String name;
	public Player(String n){
		System.out.println("name: " + name + "pC: " +playerCount);
		name = n;
		playerCount ++;
		System.out.println("name: " + name + "pC: " +playerCount);
	}
}
