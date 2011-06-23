package primeFactors;

import java.util.ArrayList;
import java.util.List;

/**
 * PrimeFactors is responsible for finding the prime factors of arbitrary numbers.
 *
 * @author skuenzli
 */
public class PrimeFactors {

	public static List<Integer> generate(Integer n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int candidate = 2;

		while (n > 1) {
			while (n % candidate == 0) {
				primes.add(candidate);
				n /= candidate;
			}
			candidate++;

		}

		return primes;
	}

}
