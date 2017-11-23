package com;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            int base = nums[i];
            int addia = 0;
            int balancerToZero = 0;
            for (int x = 0; x<nums.length;x++){
                if (x==i){
                    continue;
                }
                addia = nums[x];
                int tempbalancerToZero = base+addia;
                for (int d = 0;d< nums.length;d++){
                    if (nums[d]==tempbalancerToZero){
                        balancerToZero = nums[d];
                    }
                }
            }
            if (base+addia+balancerToZero == 0){
                List<Integer> sumZeroList = new ArrayList<>();
                sumZeroList.add(base);
                sumZeroList.add(addia);
                sumZeroList.add(balancerToZero);
                returnList.add(sumZeroList);
            }
        }
        return returnList;
    }
}
