package com;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode root = new ListNode(1);
        ListNode ptr = root;
        for(int i = 0; i < 10;i++){
            ptr.next = new ListNode(i+2);
            ptr = ptr.next;
        }

        Solution s = new Solution();
        root = s.swapPairs(root);

        while(root != null){
            System.out.print(String.valueOf(root.val) + " ");
            root = root.next;
        }
    }
}
