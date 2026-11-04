package org.study.javarush.java.core.level20.tasks20.e.temp3;

import java.util.function.Predicate;

public class Solution386 {
    public static void main(String[] args) {
        Predicate<String> isLong = text -> text.length() > 5;

        System.out.println(isLong.test("Java"));
        System.out.println(isLong.test("FunctionalInterface"));
    }
}
