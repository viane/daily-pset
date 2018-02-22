package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GA {
	ArrayList<String> sample= new ArrayList<>();;
	public GA(ArrayList<String> input) {
		for(String token : input) {
			sample.add(token);
		}
	}
	

	public ArrayList<Set<String>> classify() {
		// TODO Auto-generated method stub
		ArrayList<Set<String>> return_val = new ArrayList<>();

		for(String token : sample) {
			// calculate ASCII value sum of the token
				int token_val = 0;
				for(char c : token.toCharArray()) {
					token_val += c - '0';
				}
			// compare to all sets in the return_val
				int found_set_index = -1;
				for(int i =0; i< return_val.size();i++) {
					// fix: use token_val
					Iterator<String> it = return_val.get(i).iterator();
					// calculate ASCII value for the 1st element in set
					String str = it.toString();
					int str_val = 0;
					for(char c : str.toCharArray()) {
						str_val += c-'0';
					}
					if(str_val == token_val) 
						found_set_index = i;
				}
				
			// if no set has same ASCII value as the token
				if(found_set_index== -1) {
					// create the set with this token and add to return_val
					Set<String> s = new HashSet<>();
					s.add(token);
					return_val.add(s);
				}
			// else, add token into the set
				else {
					return_val.get(found_set_index).add(token);
				}
		}
		return return_val;
	}

}
