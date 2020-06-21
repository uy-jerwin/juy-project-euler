package juy.project.euler;

/**
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * </p>
 * 
 * @author juy
 *
 */
public class Problem3 {

	public long getLargestPrimeFactor(long input) {
		long result = 1L;
		while (result != (result = getLargestPrimeFactorInternal(input))) {
			input = result;
		}
		return result;
	}

	private long getLargestPrimeFactorInternal(long input) {
		for (long i = 2; i < input - 1; i++) {
			if (input % i == 0) {
				return input / i;
			}
		}
		return input;
	}

}
