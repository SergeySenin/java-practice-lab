package org.study.javarush.java.core.level21.tasks21.e.temp1;

public class Solution404 {
    public static void main(String[] args) {

        System.out.println(StringChecker.isEmpty(""));
        System.out.println(StringChecker.isEmpty("Java"));
    }
}

interface StringChecker {
    static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
