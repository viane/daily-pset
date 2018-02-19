package com;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import com.GA;


class Test {

	@org.junit.jupiter.api.Test
	void test() {
		ArrayList<String> sample = new ArrayList<>();
		sample.add("ab");
		sample.add("c");
		sample.add("ba");
		GA ga = new GA(sample);
		assertEquals("Failed on classify", sample, ga.classify());
	}

}
