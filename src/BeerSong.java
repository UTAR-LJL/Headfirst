
public class BeerSong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int beerNum =99;
		String word="bottles";
		while(beerNum>0) {
			if(beerNum==1) {
				word="bottle";
			}
			System.out.print(beerNum+" "+word+" of beer on the wall, ");
			System.out.println(beerNum+" "+word+" of beer");
			System.out.print("Take one down and ");
			System.out.println("Pass it around");
			beerNum=beerNum-1;
			
		}
		if(beerNum==0) {
			System.out.println("No more bottles on the wall.");
		}
	}

}
