package com;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int possibleNumber[] = {2,3,4,5,6,7,8,9};
        String testNumber = "";

        Random rand = new Random();

        int phoneNumberSize = rand.nextInt(1) + 3;

        for (int i =0; i<phoneNumberSize;i++){
            testNumber+=String.valueOf(possibleNumber[rand.nextInt(possibleNumber.length)]);
        }

        System.out.println(testNumber);

        Solution s = new Solution();

	    System.out.println(s.letterCombinations("233"));
    }
}
