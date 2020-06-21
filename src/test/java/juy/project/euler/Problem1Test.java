package juy.project.euler;

import org.junit.Assert;
import org.junit.Test;

public class Problem1Test {

	@Test
	public void solution() {
		final Problem1 p1 = new Problem1();
		Assert.assertEquals(233168, p1.solution(1000));
	}
}
