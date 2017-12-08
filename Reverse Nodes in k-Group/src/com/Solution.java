package com;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1){return head;}else if (k==2) {
            return(swapPairs(head));
        } else{
            ListNode pseudoPivot = new ListNode(0);
            pseudoPivot.next = head;
            swapByNumber(pseudoPivot, k);
            return pseudoPivot.next;
        }

    }

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

    private void swapByNumber(ListNode pivot, int k){
        if (!swappable(pivot, k)){
            // done
        }else{
            // swap
            ListNode swapBlockHead = pivot.next;
            ListNode swapBlockIntermediate = pivot;
            ListNode swapBlockTail = pivot;

            for (int i = 0;i<k;i++){
                if (i < k-1){
                    swapBlockIntermediate = swapBlockIntermediate.next;
                }
                swapBlockTail = swapBlockTail.next;
            }


//            System.out.println(swapBlockHead.val);
//            System.out.println(swapBlockIntermediate.val);
//            System.out.println(swapBlockTail.val);
            ListNode tempPtr = new ListNode(0);
            tempPtr.next = swapBlockTail.next;

            swapBlockTail.next = swapBlockHead.next;
            swapBlockHead.next = tempPtr.next;
            swapBlockIntermediate.next = swapBlockHead;
            pivot.next = swapBlockTail;

            // swap next block of k
            swapByNumber(swapBlockHead,k); // next pivot is the old "head" before swap
        }

    }

    private boolean swappable(ListNode pivot, int where){  // ex, n=4, then pivot -> [1] -> [2] -> [3] -> [4] -> ...
        if (pivot == null){
            return false;
        }

        ListNode ptr = pivot;
        for (int i =0; i< where; i ++){
            ptr = ptr.next;
            if (ptr == null){
                return false;
            }
        }

        return true;
    }
}
