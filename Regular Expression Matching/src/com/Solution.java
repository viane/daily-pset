package com;

//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true

public class Solution {
    public void Solution(){

    }

    public boolean isMatch(String original, String pattern){
        if (pattern.length()==0 && original.length()!=0){
            return false;
        }
        // no "*" in the pattern, the original string must match exact pattern
        if (pattern.indexOf('*') == -1){
            if (!original.equals(pattern)){
                return false;
            }else{
                return true;
            }
        }else{
            // 1. single char, ex a,b,3
            if (pattern.indexOf('*') != 1){
                // compare next char of original string and pattern
                if (original.substring(0,1).equals(pattern.substring(0,1))){
                    String newOriginal = original.substring(1);
                    String newPattern = pattern.substring(1);
                    return isMatch(newOriginal,newPattern);
                }else{
                    return false;
                }
            }else {
                if (!pattern.substring(0,1).equals(".")){  // 2. 0 or more multiple repeating single chars, ex a*, 1*, x*
                    String currentPattern = pattern.substring(0,1); // a,b,1,...
                    String newOriginal = original;
                    if (newOriginal.length()==0 && currentPattern.length()>=3){
                        return false;
                    }
                    if (newOriginal.length()==0 && currentPattern.length()<3){
                        return true;
                    }
                    while(newOriginal.substring(0,1).equals(currentPattern)){ // while original string has pattern char in front
                        newOriginal = newOriginal.substring(1); // pop front char
                        if (newOriginal.length()==0 && currentPattern.length()>=3){
                            return false;
                        }
                        if (newOriginal.length()==0 && currentPattern.length()<3){
                            return true;
                        }
                    }
                    String newPattern = pattern.substring(2);
                    return isMatch(newOriginal,newPattern);
                }else {  // 3. 0 or more multiple unknown chars ex .*a...
                    if (pattern.length()==2){ // pattern only has .*, it will always match everything
                        return true;
                    }
                    String newPattern = pattern.substring(2,3);
                    String newOriginal = original;
                    while(newOriginal.length()>0 && !newOriginal.substring(0,1).equals(newPattern)){
                        newOriginal = newOriginal.substring(1);
                    }
                    return isMatch(newOriginal,newPattern);
                }
            }
        }
    }
}
