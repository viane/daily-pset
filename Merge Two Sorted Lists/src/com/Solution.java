package com;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else{
            if (l1.val<l2.val){

                l1.next = merge(l1.next,l2);
                return l1;
            }else{

                l2.next = merge(l1,l2.next);
                return l2;
            }
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1,l2);
    }
}