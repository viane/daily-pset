#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Nov  8 01:06:13 2017

@author: allen
"""

import sys

class Solution:
    maxLssLength = 0
    maxLss = ""
    
    checkStr = ""
    checkStrLen =0
    
    def outBound(self,index):
        if index < 0:
            return True
        if index > self.checkStrLen-1:
            return True
        return False
    
    def longestPalindrome(self,s):
        print("\nTest sample string: ", s,"\n")
        """
        :type s: str
        :rtype: str
        """
        self.checkStr = s
        self.checkStrLen = len(s)
        for i in range(0, len(s)):
            print("\nExaming char ", s[i])
            potentialLSS = s[i]
            shorterDistance = 0
            if i - 0 > len(s) - 1 - i: #current char is on the right side of str
                print("Char closes to end")
                shorterDistance = len(s)-1 - i
                print("There are ", shorterDistance, " surrounding chars need to check on each side")
                for x in range(1, shorterDistance+1):
                    # scan to right
                    if not self.outBound(i+x): #bound is at last char
                        print("Checking ", x, "position(s) around the char")
                        print("They are ", s[i-x],"(left) and ", s[i+x], "(right)")
                        if s[i-x] == s[i+x]: # if mirror
                            print("They are same chars")
                            potentialLSS = s[i-x] + potentialLSS + s[i+x] # add both at ends
                            if len(potentialLSS) > self.maxLssLength: # current palindrom is longer than record
                                self.maxLss = potentialLSS
                                self.maxLssLength = len(potentialLSS)
                        else:
                            print("Not same char")
                            break
                        print("Current potential max palindrome string is ", potentialLSS, '\n')
            else:
                print("Char closes to start")
                shorterDistance = i-0
                print("There are ", shorterDistance, " surrounding chars need to check on each side")
                for x in range(1, shorterDistance+1):
                    # scan to left
                    if not self.outBound(i-x): #bound is at first char
                        print("Checking ", x, "position(s) around the char")
                        print("They are ", s[i-x],"(left) and ", s[i+x], "(right)")
                        if s[i-x] == s[i+x]: # if mirror
                            print("They are same chars")
                            potentialLSS = s[i-x] + potentialLSS + s[i+x] # add both at ends
                            if len(potentialLSS) > self.maxLssLength: # current palindrom is longer than record
                                self.maxLss = potentialLSS
                                self.maxLssLength = len(potentialLSS)
                        else:
                            print("Not same char")
                            break
                        print("Current potential max palindrome string is ", potentialLSS, '\n')
            print("-----------------------------------------------------------------")
        
        if self.maxLssLength == 0:
            return "No Palindrome Substring"
        else:
            return self.maxLss
    
def main():
    testStr=""
    if len(sys.argv) > 1:
        testStr = sys.argv[1]
    else:
        testStr= "aababac"
    print("\nCheck longest palindrome string of \"", testStr , "\" : ", Solution().longestPalindrome(testStr))    
    
if __name__ == "__main__":
    main()