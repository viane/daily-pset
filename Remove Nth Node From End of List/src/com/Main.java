package com;

public class Main {

    public static void main(String[] args) {
	    int [] nums = {1,2,3,4,5};
	    ListNode root = new ListNode(nums[0]);
	    ListNode tempRoot = root;
	    for (int i=1;i<nums.length;i++){
	        ListNode nextNode = new ListNode(nums[i]);
	        tempRoot.next = nextNode;
	        tempRoot = nextNode;
        }

        Solution s = new Solution();
        tempRoot = s.removeNthFromEnd(root,3);

        while(tempRoot.next != null){
            System.out.println(tempRoot.val);
            tempRoot=tempRoot.next;
        }
        System.out.println(tempRoot.val);
    }
}
