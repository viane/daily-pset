package com;

import static org.junit.Assert.*;

import org.junit.Test;
import com.Solver;


public class SolverTest {
	@Test
	public void testMultiply() {
		Solver s = new Solver();
		assertEquals("Should equal",s.multiply("123", "321"),"39483");
	}

}
