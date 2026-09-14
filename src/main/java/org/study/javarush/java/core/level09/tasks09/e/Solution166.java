package org.study.javarush.java.core.level09.tasks09.e;

public class Solution166 {
    public static void main(String[] args) {

        String firstWord = "apple";
        String secondWord = "banana";

        System.out.println(firstWord.compareTo(secondWord));

        String temp = firstWord;
        firstWord = secondWord;
        secondWord = temp;

        System.out.println(firstWord.compareTo(secondWord));
    }
}
