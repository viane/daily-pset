package com;

public class Solution {
    Solution(){}

    public String longestCommonPrefix(String[] strs) {
        // find shorest strings in strs
        int strLength = strs[0].length();
        for (int i =0;i<strs.length;i++){
            if (strLength>strs[i].length()){
                strLength = strs[i].length();
            }
        }
        String prefix = "";
        for (int i = 0; i<strLength;i++){
            for (int x = 1; x < strs.length;x++){
                if (!strs[x].substring(i,i+1).equals(strs[x-1].substring(i,i+1))){
                    return prefix;
                }
            }
            prefix+=strs[0].substring(i,i+1);
        }
        return prefix;
    }
}
