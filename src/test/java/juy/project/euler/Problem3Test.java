package juy.project.euler;

import org.junit.Assert;
import org.junit.Test;

public class Problem3Test {

	@Test
	public void solution() {
		final Problem3 p3 = new Problem3();
		Assert.assertEquals(6857L, p3.getLargestPrimeFactor(600851475143L));
	}
}
