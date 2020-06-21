package juy.project.euler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem4Test {

	private Problem4 p4;

	@Before
	public void init() {
		p4 = new Problem4();
	}

	@Test
	public void solution() {
		Assert.assertEquals(906609, p4.largestPalindromeProduct());
	}

	@Test
	public void shouldEvaluatePalindrome() {
		Assert.assertTrue(p4.isPalindrome(13431));
		Assert.assertTrue(p4.isPalindrome(1221));

		Assert.assertFalse(p4.isPalindrome(12341));
		Assert.assertFalse(p4.isPalindrome(1231));

	}
}
