package juy.project.euler;

import org.junit.Assert;
import org.junit.Test;

public class Problem5Test {

	@Test
	public void solution() {
		final Problem5 p5 = new Problem5();
		Assert.assertEquals(232792560, p5.solution());
	}
}
