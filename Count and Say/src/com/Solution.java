package com;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        for (Integer s : generateNth(n))
        {
            sb.append(s);
        }

        return sb.toString();
    }

    protected ArrayList<Integer> modifyPreviousSequence(ArrayList<Integer> preSeq){

        ArrayList<Integer> modifiedSequence = new ArrayList<>();

        int count = 1, i = 0;
        for (; i < preSeq.size() -1; i++) {
            if (preSeq.get(i) != preSeq.get(i+1)){
                modifiedSequence.add(count);
                modifiedSequence.add(preSeq.get(i));
                count = 0;
            }
            count++;
        }

        // manual check for last index
        if (preSeq.get(i) != preSeq.get(i-1)){
            modifiedSequence.add(1);
            modifiedSequence.add(preSeq.get(i));
        }else{
            modifiedSequence.add(count);
            modifiedSequence.add(preSeq.get(i));
        }


        return modifiedSequence;
    }

    protected ArrayList<Integer> generateNth(int n){

        if (n<1){
            ArrayList<Integer> r =new ArrayList<>(Arrays.asList(1));
            return r;
        }

        switch (n){
            case 1:
                ArrayList<Integer> r = new ArrayList<>(Arrays.asList(1));
                return r;
            case 2:
                r = new ArrayList<>(Arrays.asList(1,1));
                return r;
        }


        ArrayList<Integer> previousSequence = generateNth(n-1);

        ArrayList<Integer> currentSequence = modifyPreviousSequence(previousSequence);

        return currentSequence;
    }
}