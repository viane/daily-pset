package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        ListNode[] ln;
        int size = rand.nextInt(1000) + 0;
        ln = new ListNode[size];

        for (int i =0; i < size ;i++){
            ln[i] = new ListNode(rand.nextInt(5000 + 0 + 5000) - 5000);
        }

        System.out.println("Test array: ");

        for (ListNode n : ln){
            System.out.print(String.valueOf(n.val)+" ");
        }


        System.out.println("\nSorted array: ");
        Solution s = new Solution();

        ListNode root = s.mergeKLists(ln);
        while (root != null){
            System.out.print(String.valueOf(root.val) + " ");
            root = root.next;
        }
    }
}
