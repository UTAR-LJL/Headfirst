package week7;

public class Vet {
	
	public void getShot(Animal a) {
		a.roam();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vet v = new Vet();
		Dog d = new Dog();
		Lion l = new Lion();
		Wolf w = new Wolf();
		v.getShot(d);	
		v.getShot(l);
		v.getShot(w);
	}

}
