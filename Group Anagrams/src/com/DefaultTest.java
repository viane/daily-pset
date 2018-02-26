package com;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DefaultTest {

	@Test
	public void test() {
		String[][] answerStrs = {{"tan", "nat"}, {"bat"}, {"tea", "ate","eat"}};
		List<List<String>> answer = new ArrayList<List<String>>();
		
		for(String[] strAry : answerStrs) {
			answer.add(Arrays.asList(strAry));
		}
		
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		GA ga = new GA();
		
		
		assertTrue(answer.equals(ga.groupAnagrams(strs)));

	}

}
