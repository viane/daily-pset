package com;

public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l1Temp = l1;
        ListNode l2 = new ListNode(1);
        ListNode l2Temp = l2;
        for (int i = 1; i < 5; i++){
            ListNode add = new ListNode(i*2);
            l1Temp.next = add;
            l1Temp = l1Temp.next;

            ListNode add2 = new ListNode(i*2+1);
            l2Temp.next = add2;
            l2Temp = l2Temp.next;
        }
        

        Solution s = new Solution();
        ListNode sol = s.mergeTwoLists(l1,l2);
        while(sol.next != null){
            System.out.println(sol.val);
            sol = sol.next;
        }

    }
}
