import java.util.*;

public class Solution {
    public List<String> ans = new ArrayList<String>();
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0, windowEnd=0;
        int strLength = s.length();

        // scan left to right, if next char is repeated, store previous count of substr lenght, compare to maxLength, if previous count is lager, replace the maxLength with previous count, then keep scan until end of str
        List<Character> window = new ArrayList<Character>();
        while(windowEnd<strLength){
            // check
            if (!window.contains(s.charAt(windowEnd))){ // if next char is not repeated
                // append next char to window
                window.add(s.charAt(windowEnd));
            }else{
                // remove everything before include repeated char in the window
                int deleteIndex =  0;
                while(deleteIndex <= window.indexOf(s.charAt(windowEnd))){
                   window.remove(deleteIndex);
                }

                // append next char to window
                window.add(s.charAt(windowEnd));
            }


            maxLength = Math.max(maxLength, window.size());

            // store possible longest substr
            String temp = new String();
            for (int i = 0; i < window.size(); i++){
                temp += window.get(i);
            }
            ans.add(temp);

            // finish current check
            windowEnd++;
        }
        return maxLength;
    }
}
