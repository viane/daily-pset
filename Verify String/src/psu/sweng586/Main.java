/**
 * Coding Challenge 1
 * Author: Xiaoyu Zhou
 * PSUID: xpz5043
 * Date: May 9, 2018
 *
 **/

package psu.sweng586;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static String verifyString(String s){
        boolean isValid = true;
        Pattern allowedRegex = Pattern.compile("[^A-Za-z0-9]");
        if(s.length()<8){
            isValid = false;
        }else if(s.trim().length() != s.length()){
            isValid = false;
        }else if(allowedRegex.matcher(s).find()){
            isValid = false;
        }

        return (isValid)? "valid" : "invalid";
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your string:");
        try {
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                System.out.println("\"" + input + "\" is " + verifyString(input));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
