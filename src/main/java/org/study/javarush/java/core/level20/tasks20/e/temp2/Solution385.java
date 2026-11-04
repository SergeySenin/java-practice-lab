package org.study.javarush.java.core.level20.tasks20.e.temp2;

public class Solution385 {
    public static void main(String[] args) {
        NumberChecker checker = n -> n > 100;

        System.out.println(checker.check(50));
        System.out.println(checker.check(150));
    }
}

@FunctionalInterface
interface NumberChecker {
    boolean check(int n);
}
