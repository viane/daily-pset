package com;


public class Main {

    public static void main(String[] args) {
        int test = 100101001;
	 System.out.println("Check " + String.valueOf(test) +" is palindrome: "+  String.valueOf(new Solution().isPalindrome(test)));
    }
}
