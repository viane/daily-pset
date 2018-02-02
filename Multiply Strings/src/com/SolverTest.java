package com;

import static org.junit.Assert.*;

import org.junit.Test;
import com.Solver;
import static org.junit.Assert.assertNotEquals;

public class SolverTest {
	@Test
	public void testMultiply() {
		Solver s = new Solver();
		try {
			assertNotEquals("Should not equal","2",s.multiply("1", "1"));
			assertEquals("Should equal","81",s.multiply("9", "9"));
			assertEquals("Should equal","39483",s.multiply("123", "321"));
			assertEquals("Should equal","121932631112635269",s.multiply("123456789", "987654321"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
