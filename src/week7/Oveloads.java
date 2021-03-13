package week7;

public class Oveloads {
	
	String uniqueID;
	public int addNums(int a, int b) {
		return a + b;
		
	}
	
	public double addNums(double a, double b) {
		return a + b;
	}
	
	public void setUnique(String theID) {
		uniqueID = theID;
	}
	
	public void setUniqueID(int s) {
		String numString = "" + s;
		setUnique(numString);
	}

}
