package com;

// 1,2,3,4 -> 2,1,4,3

// 1,2,3,4,5 -> 2,1,4,3,5

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private void swap(ListNode pivot){
        if ( pivot == null || pivot.next == null || pivot.next.next == null){

        }else{
            ListNode swapFront = pivot.next;
            ListNode swapBack = pivot.next.next;

            pivot.next = swapBack;
            swapFront.next = swapBack.next;
            swapBack.next = swapFront;


            swap(swapFront);
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode fakeRoot = new ListNode(0);
        ListNode returnNode = head.next;

        fakeRoot.next = head;

        swap(fakeRoot);

        return returnNode;
    }
}