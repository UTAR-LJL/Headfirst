
public class POM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] wordOne= {"24/7","multi-Tiar","30,OOO foot", "B-to-B" , "win-win" , "front-end" , "web- based" , "pervasive", "smart", "six-sigma", "cri tical-path" , "dynamic"};
		String[] wordTwo= {"empowered", "sticky",
				"value-added.", "oriented", "centric", "distributed",
				"clustered", "branded", "outaide-the-box", "positioned",
				"networked", " focused" ,"leveraged", "aligned",
				"targeted", "shared" , "cooperative", "accelerated"};
		String[] wordThree= {"process", "tippingpoint", "solution", "architecture", "core competency" ,
				"strategy", "mindshare", "portal" , "apace", "vision",
				"~adigm", "~ssion"};
		int oneLen=wordOne.length;
		int twoLen=wordTwo.length;
		int threeLen=wordThree.length;
		
		int randOne=(int)(Math.random()*oneLen);
		int randTwo=(int)(Math.random()*twoLen);
		int randThree=(int)(Math.random()*threeLen);
		
		String phrase=wordOne[randOne]+" "+wordTwo[randTwo]+" "+wordThree[randThree];
		
		System.out.println("what we need is a "+phrase);
	}

}
