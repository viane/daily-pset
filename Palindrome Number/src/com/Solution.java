package com;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int length = String.valueOf(x).length();
        String intAry[] =  String.valueOf(x).split("");
        int leftStartIndex;
        int rightStartIndex;
        if(length%2==0){
            leftStartIndex = (length-1) /2;
            rightStartIndex = (length-1)/2+1;
        }else{
            leftStartIndex = length/2-1;
            rightStartIndex = length/2+1;
        }
        for(;rightStartIndex < length;){
            //System.out.println(intAry[leftStartIndex] + intAry[rightStartIndex]);
            if(!intAry[leftStartIndex].equals(intAry[rightStartIndex])){
                return false;
            }
            leftStartIndex--;
            rightStartIndex++;
        }
        return true;
    }
}