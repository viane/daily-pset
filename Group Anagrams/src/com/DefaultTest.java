package com;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DefaultTest {

	@Test
	public void test() {
		ArrayList<String> sample = new ArrayList<>();
		sample.add("ab");
		sample.add("c");
		sample.add("ba");
		GA ga = new GA(sample);
		assertEquals("Failed on classify", sample, ga.classify());
	}

}
