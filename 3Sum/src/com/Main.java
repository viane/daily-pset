package com;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        int nums[] = {-1,0,1,1,0,3,2,-2};
        System.out.println("Array: "+ Arrays.toString(nums));
        System.out.println("3 numbers sum to zero: " + s.threeSum(nums));
    }
}
