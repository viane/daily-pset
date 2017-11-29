package com;

import java.util.*;

public class Solution {
    List<String> combinations = new ArrayList<>();
    List<String> returnList = new ArrayList<>();

    private void perm(int currentDigitIndex, String combination) {
        if (currentDigitIndex == combinations.size()){
            returnList.add(combination);
            return;
        }

        for (int i=0;i<combinations.get(currentDigitIndex).length();i++){ // a,b,c
            String new_combination = String.valueOf(combination) + String.valueOf(combinations.get(currentDigitIndex).charAt(i));
            perm(currentDigitIndex+1,new_combination);
        }

    }


    public List<String> letterCombinations(String digits) {
        combinations.clear();
        returnList.clear();

        if (digits.length()==0){
            return new ArrayList<String>();
        }

        HashMap hm = new HashMap();
        hm.put("2","abc");
        hm.put("3","def");
        hm.put("4","ghi");
        hm.put("5","jkl");
        hm.put("6","mno");
        hm.put("7","pqrs");
        hm.put("8","tuv");
        hm.put("9","wxyz");



        for (int i =0;i<digits.length();i++){
            if(!hm.containsKey(String.valueOf(digits.charAt(i)))){
                return combinations;
            }
        }

        // ex 482

        int combinationLength = digits.length();

        for (int i = 0;i<combinationLength;i++){

            String digitCombinationLetters = hm.get(String.valueOf(digits.charAt(i))).toString();
            combinations.add(digitCombinationLetters);

        }


        perm(0,"");

        return returnList;

    }
}
