package com;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.frequency;

public class Solution {
    private class Finder implements Callable<List<Integer>>{
        List<Integer> nums;
        int workingIndex;
        public void setInitValue(List<Integer> numsList, int index){
            nums = numsList;
            workingIndex = index;
        }

        public List<Integer> call(){
            List<Integer> returnList = new ArrayList<>();

            final Integer base = nums.get(workingIndex);

            for (int i =0; i<nums.size();i++){
                if (i==workingIndex){
                    continue;
                }else{
                    Integer addi = nums.get(i);
                    Integer differenceToZero = 0-base-addi;

                    int differenceOccurrence = Collections.frequency(nums, differenceToZero);

                    if (differenceOccurrence>0){
                        returnList.add(base);
                        returnList.add(addi);
                        returnList.add(differenceToZero);
                        return returnList;
                    }
                }
            }
            return returnList;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numsList = IntStream.of(nums).boxed().collect(Collectors.toList());
//        System.out.println(numsList);
        List<List<Integer>> returnList = new ArrayList<>();

        final ExecutorService service;
        service = Executors.newFixedThreadPool(nums.length);

        for (int i =0; i < nums.length;i++){

            final Future<List<Integer>> task;

            Finder f = new Finder();
            f.setInitValue(numsList,i);
            task    = service.submit(f);

            try {
                final List<Integer> tempList;
                tempList = task.get(); // this raises ExecutionException if thread dies

                if (tempList.size()>0) {
                    returnList.add(tempList);
                }
            } catch(final InterruptedException ex) {
                ex.printStackTrace();
            } catch(final ExecutionException ex) {
                ex.printStackTrace();
            }
        }

        service.shutdownNow();

        // remove duplicates

        for (int i =0;i<returnList.size();i++){
            Collections.sort(returnList.get(i));
        }

        Set<List<Integer>> hs = new HashSet<>();
        hs.addAll(returnList);
        returnList.clear();
        returnList.addAll(hs);

        return returnList;
    }
}

