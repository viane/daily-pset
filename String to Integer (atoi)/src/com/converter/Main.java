package com.converter;

public class Main {

    public static void main(String[] args) {
        String testInput = "9193011810193131";
        ToInt converter = new ToInt(testInput);
        System.out.println(converter.strToInt());
    }
}
