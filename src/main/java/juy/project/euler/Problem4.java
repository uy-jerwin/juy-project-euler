package juy.project.euler;

/**
 * <p>
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * </p>
 * 
 * @author juy
 *
 */
public class Problem4 {

	public int largestPalindromeProduct() {
		int current = 0;
		for (int i = 999; i > 99; i--) {
			for (int j = i; j > 99; j--) {
				int product = i * j;
				if (product > current && isPalindrome(product)) {
					current = product;
				}
			}
		}
		return current;
	}

	public boolean isPalindrome(int input) {
		final String param = String.valueOf(input);
		final char[] params = param.toCharArray();
		int length = params.length;
		int lastIndex = length - 1;
		for (int i = 0, j = lastIndex; i <= j; i++, j--) {
			if (params[i] != params[j]) {
				return false;
			}
		}
		return true;
	}
}
