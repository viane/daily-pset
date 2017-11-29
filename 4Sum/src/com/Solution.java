package com;

import java.util.*;

public class Solution {

    int sumSize = 4;

    int nums[] = {};
    List<List<Integer>> returnList = new ArrayList<>();
    int target = 0;

    private void perm(int[] sums,int currentIndex){
        if (currentIndex == sumSize){
            int index =0;
            int sum = 0;
            while (index<sums.length){
                sum+=sums[index];
                index++;
            }
            if (sum==target){
                List<Integer> temp = new ArrayList<>();
                for (int item:sums){
                    temp.add(item);
                }
                returnList.add(temp);
            }
        }else{
            for (int i =0;i<nums.length;i++){
                sums[currentIndex] = nums[i];
                int newSums[] = sums.clone();
                perm(newSums,currentIndex+1);
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.target = target;
        this.nums= nums;
        int sums[] = new int[4];
        perm(sums,0);

        Set<List<Integer>> hs = new HashSet<>();
        hs.addAll(returnList);
        returnList.clear();
        returnList.addAll(hs);
        System.out.println(returnList);
        return returnList;
    }
}
