package com;

public class Main {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode ptr = root;
        for (int i = 2; i < 11;i++){
            ListNode temp = new ListNode(i);
            ptr.next = temp;
            ptr = ptr.next;
        }

        Solution s = new Solution();
        ListNode result = s.reverseKGroup(root,4);

        while(result.next != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
