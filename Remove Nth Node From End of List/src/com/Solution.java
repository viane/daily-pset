package com;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int removeNodeIndex) {
        ListNode tempRoot = head;
        ListNode shouldRemove = head;
        int onIndex = 0;

        while(tempRoot.next != null){
            tempRoot = tempRoot.next;
            onIndex+=1;

            if(onIndex>removeNodeIndex){
                shouldRemove = shouldRemove.next;
            }

        }

        if (onIndex+1>removeNodeIndex){
            shouldRemove.next = shouldRemove.next.next;

        } else {
            // removing root
            head = head.next;

        }
        return head;
    }
}
