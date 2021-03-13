import java.lang.Math;
/**
 * GetPrime
 * Get prime numbers between 2 and 100
 * week3
 * @author Hao
 */
public class Getprime {
 
    public static void main(String[] args) {
        int upperBound = 10000;
        boolean []isPrime = new boolean[upperBound+1];

        // Initialize the elements of the array to true.
        // Even numbers except 2 are automatically excluded.
        isPrime[2] = true;
        for(int i=3; i<isPrime.length; i+=2)
        {
            isPrime[i] = true;
        }

        // Iterate through all the prime numbers less than or equal to 
        // the square root of the upper bound 10000 which is 100
        // set the numbers that are multiples of the current prime
        for(int i=3; i<=Math.sqrt(upperBound); i++)
        {
            if(isPrime[i] == true)
            {
                // The numbers before i*i have been processed.
                for(int j=i; i*j <= upperBound; j++)
                {
                    isPrime[i*j] = false;
                }
            }
        }

        // Print the indices with the boolean value set to true.
        int j =0,k = 0;
        for(boolean primeBool: isPrime)
        {
            if(primeBool == true)
            {
                k++;
                System.out.print("\t" + j);

                if(k%10 == 0)
                {
                    System.out.println();
                }
            }
            j++;
        }
        
    }
 }