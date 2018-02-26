package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GA {
	protected List<List<String>> groupAnagrams(String[] strs) {
		// TODO Auto-generated method stub

		// map of <ASCII sum, {subStrs..}>
		HashMap<Integer, List<String>> groupHash = new HashMap<>();
		
		
		// for each word, check ASCII sum, if sum exists, append to corresponded set, 
		// if sum is new, add new <ASCII sum, word> pair to groupHash
		for(String token : strs) {

			// calculate ASCII value sum of the token
			int word_ascii_val = 0;
			for(char c : token.toCharArray()) {
				word_ascii_val += c - '0';
			}
			
			if(groupHash.containsKey(word_ascii_val)) {
				groupHash.get(word_ascii_val).add(token);
			}else {
				List<String> s = new ArrayList<String>();
				s.add(token);
				groupHash.put(word_ascii_val, s);
			}
			
		}
		
		List<List<String>> returnList = new ArrayList<List<String>>();
		
		// reformat
		groupHash.forEach((key,val)->{
			List<String> temp = new ArrayList<>();
			for(String token : val) {
				temp.add(token);
			}
			returnList.add(temp);
		});
		

		// Done
		return returnList;
	}

}
