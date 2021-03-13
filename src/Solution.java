import java.math.BigInteger;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int T = cin.nextInt();
		for(int ca = 1; ca <= T; ca ++ )
		{
			System.out.print("Case #" + ca + ": ");
			BigInteger N;
			int L;
			N = cin.nextBigInteger();
			L = cin.nextInt();
			
			BigInteger[] num = new BigInteger[105];
			BigInteger[] ans = new BigInteger[105];
			
			for(int i = 1; i <= L; i ++ )
			{
				num[i] = cin.nextBigInteger();
			}
			
			TreeSet<BigInteger> set = new TreeSet<BigInteger>();
			for(int i = 1; i < L - 1; i ++ )
			{	
				if(num[i].equals(num[i + 1]))
					continue;
				BigInteger k = num[i].gcd(num[i + 1]);
				ans[i + 1] = k;
				set.add( k );
			}
			
			
			
			//sort
			TreeMap<BigInteger, Character> map = new TreeMap<BigInteger, Character>();
			
			char st = 'A';
			for(BigInteger item : set) {
				map.put(item, st);
				st++;
			}
				
			
			for(int i = 1; i <= L + 1; i ++ )
			{
				
				System.out.print(map.get(ans[i]));
			}
			
			System.out.println("");
		}
	}

}
