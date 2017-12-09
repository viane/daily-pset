package com;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int afterRemoveSize = nums.length;
        for (int i =0;i<nums.length;i++){
            if (nums[i]==val){
                afterRemoveSize--;
            }
        }
        return afterRemoveSize;
    }
}
