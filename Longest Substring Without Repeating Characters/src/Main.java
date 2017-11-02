import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<String> testCase = new ArrayList<String>();
        testCase.add("AA");
        testCase.add("AcBcdEckiu");
        testCase.add("geeksforgeeks");
        testCase.add("LjaLJASdlajKAJSl");
        for (int i = 0; i<testCase.size(); i++){
            System.out.println("------------------------------\nTest String: " + testCase.get(i));
            Solution s = new Solution();
            int maxLength =  s.lengthOfLongestSubstring(testCase.get(i));
            System.out.println("Longest Substring Length: " + maxLength + "\nAnswer Substrings:");

            for (int x = 0; x < s.ans.size(); x++) {
                if (s.ans.get(x).length() == maxLength) {
                    System.out.println(s.ans.get(x));
                }
            }
        }

    }
}
