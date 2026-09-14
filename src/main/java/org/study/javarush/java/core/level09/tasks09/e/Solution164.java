package org.study.javarush.java.core.level09.tasks09.e;

public class Solution164 {
    public static void main(String[] args) {

        String firstString = "Hello";
        String secondString = "HELLO";

        boolean areEqual = firstString.equalsIgnoreCase(secondString);

        System.out.println(areEqual);
    }
}
