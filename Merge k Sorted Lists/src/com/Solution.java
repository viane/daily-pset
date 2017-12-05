package com;

import java.util.*;

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
        if  (l1 == null && l2 == null){
            return null;
        }

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

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1,l2);
    }

    private static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            if(n1==null && n2==null){
                return 0;
            }else if(n1 == null){
                return -1;
            }else if(n2 == null){
                return 1;
            }
            return n1.val - n2.val;
        }
    }



    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length ==0){
            return null;
        }
        List<ListNode> returnList = new ArrayList<>(Arrays.asList(lists));

        while (returnList.size()>1){
            Collections.sort(returnList,new ListNodeComparator());

            ListNode n1 = returnList.remove(0);

            ListNode n2 = returnList.remove(0);

            returnList.add(mergeTwoLists(n1,n2));

        }

        return returnList.get(0);
    }
}