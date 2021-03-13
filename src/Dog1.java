
public class Dog1 {
	
	String name;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog1 dog1 = new Dog1();
		dog1.bark();
		dog1.name = "bart";
		
		Dog1[] myDogs = new Dog1[3];
		myDogs[0] = new Dog1();
		myDogs[1] = new Dog1();
		myDogs[2] = new Dog1();
		
		myDogs[0].name = "fred";
		myDogs[1].name = "Marge";
		
		System.out.println("2: " + myDogs[2].name);
		
		int x = 0;
		while(x < myDogs.length)
		{
			myDogs[x].bark();
			x = x + 1;
		}
		
	}
	
	public void bark()
	{
		System.out.println(name + " says Ruff");
	}

}
