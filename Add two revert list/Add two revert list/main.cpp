//
//  main.cpp
//  Add two revert list
//
//  Created by xiaoyu zhou on 10/30/17.
//  Copyright © 2017 xiaoyu zhou. All rights reserved.
//


/* 
P-set:
        You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
*/

#include <iostream>


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) {
        this->val = x;
        this->next = NULL;
    }
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // temp pointer
        ListNode* temp1 = l1;
        ListNode* temp2 = l2;
        // store length
        unsigned int length1 = 1;
        unsigned int length2 = 1;
        // check length 1
        while(temp1->next != NULL){
            length1++;
            temp1 = temp1->next;
        }
        // check length 2
        while(temp2->next != NULL){
            length2++;
            temp2 = temp2->next;
        }
        
        ////////////////////////////////////////////////////////
        // 2 cases:
        // - list has same length
        // - list has different length
        ////////////////////////////////////////////////////////
        
        // same length, add from left to right from same postion for each list, with carry digit(bool) default false
        temp1 = l1;
        temp2 = l2;
        // psudo fake root, actual root is r->next
        ListNode* r = new ListNode(0);
        ListNode* currentRoot = r;
        if(length1 == length2){
            bool carry = false;
            for(int digitCount=0; digitCount<length1; digitCount++){
                int digitSum = temp1->val + temp2->val;
                // check and apply previous carry
                if(carry){
                    digitSum++;
                }
                // if sum is greater than 10, set carry for next digit sum
                if(digitSum>=10){
                    carry = true;
                }else{
                    carry = false;
                }
                // get single digit sum
                digitSum = digitSum % 10;
                // make a node
                ListNode* tempNode = new ListNode(digitSum);
                // append to current root
                currentRoot->next = tempNode;
                // move to next
                currentRoot = currentRoot->next;
                // move to next pointer
                temp1 = temp1->next;
                temp2 = temp2->next;
            }
            // end sum but if last add has carry out
            if (carry) {
                currentRoot ->next = new ListNode(1);
            }
        }else{
            // same methology, but instead adding from same starting position, adding from shortter list start position for both list and prepend preserved digit from longer list
            if(length1>length2){
                int preserveDigitCount = length1 - length2;
            }else{
                
            }
        }
        
        return r->next;
    }
};

int main(){
    
    // test
    // [3->6->5]
    ListNode* l1 = new ListNode(3);
    l1->next = new ListNode(6);
    l1->next->next = new ListNode(5);
    
    // [5->9->8]
    ListNode* l2 = new ListNode(5);
    l2->next = new ListNode(9);
    l2->next->next = new ListNode(8);
    
    // expect [8->5->4->1]
    std::cout << '[';
    ListNode*r = Solution().addTwoNumbers(l1, l2);
    ListNode* tempRoot = r;
    do {
        if (tempRoot->next!=NULL) {
            std::cout << tempRoot->val << "->";
        }else{
            std::cout << tempRoot->val;
        }
        
        tempRoot= tempRoot->next;
    }while (tempRoot != NULL);
    
    std::cout << ']' << std::endl;
    return 0;
}
