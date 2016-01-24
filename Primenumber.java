
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Primenumber {
	public static void main(String[] args) {
		int N = 0, k = 0, max = 0, numb;
		HashMap<Integer, Integer> PrimeIndices = new HashMap<Integer, Integer>();
		Scanner in = new Scanner(System.in);
		
		
		
		System.out.println("Number of Prime Indices to be searched for:\n");

		int num = in.nextInt();
			
		if (num <= 0) {
			System.out.println("Please enter positive integer");
			return;
		}

		System.out.println("Enter the numbers to be searched");
		for (int i = 1; i <= num; i++) {
			numb = in.nextInt();
			
			if(numb<=0)
			{
				System.out.println("Re enter a positive number");
				i--;
				continue;
			}
			if(PrimeIndices.containsKey(numb)==true)
			{
				System.out.println("Re enter a distinct number");
				i--;
				continue;
			}
			
			if (max < numb) {
				max = numb;
			}
			
			PrimeIndices.put(numb, numb);
			if (i == num) {
				N = max * max;
			}
		}
		

		// initially assume all integers are prime
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= N; i++) {

			// if i is prime, then mark multiples of i as nonprime
			if (isPrime[i]) {
				for (int j = i; i * j <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		// count primes
		int primes = 0;

		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				primes++;
				if (PrimeIndices.containsKey(primes)) {
					System.out.println("Index: " + primes + " --> " + i);
					
				}

			}

		}

	}
}