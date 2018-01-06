package com;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DateTime start = new DateTime();
        Solution s = new Solution();
        String result = s.countAndSay(6);
        DateTime end = new DateTime();
        Interval interval = new Interval(start, end);
        System.out.println("6: " + result + " used " + interval.toDurationMillis() + "ms");
    }
}
