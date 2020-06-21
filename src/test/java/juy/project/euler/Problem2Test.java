package juy.project.euler;

import org.junit.Assert;
import org.junit.Test;

public class Problem2Test {

	@Test
	public void solution() {
		final Problem2 p2 = new Problem2();
		Assert.assertEquals(4613732, p2.solution(4000000));
	}

}
