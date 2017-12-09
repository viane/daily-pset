package com;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()==0 || needle.length()>haystack.length()){
            return -1;
        }
        for (int i =0;i<haystack.length();i++){
            if (haystack.charAt(i)==needle.charAt(0)){
                for (int x = 1; x < needle.length();x++){
                    if (haystack.charAt(i+x) != needle.charAt(x)){
                        i += needle.length();
                        if (i>=haystack.length()){
                            return -1;
                        }
                    }
                }
                return i;
            }
        }
        return -1;
    }
}
