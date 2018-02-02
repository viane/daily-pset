package com;

import static org.junit.Assert.*;

import org.junit.Test;
import com.Solver;


public class SolverTest {
	@Test
	public void testMultiply() {
		Solver s = new Solver();
		try {
			assertEquals("Should equal","25",s.multiply("5", "5"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
