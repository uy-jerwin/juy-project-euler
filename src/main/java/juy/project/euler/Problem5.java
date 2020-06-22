package juy.project.euler;

/**
 * <p>
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * </p>
 * 
 * @author juy
 *
 */
public class Problem5 {

	public int solution() {
		int counter = 1;
		while (true) {
			int current = 20 * counter;
			if (isDivisble(current)) {
				return current;
			}
			counter++;
		}
	}

	public boolean isDivisble(int param) {
		for (int i = 1; i <= 20; i++) {
			if (param % i != 0) {
				return false;
			}
		}
		return true;
	}

}
