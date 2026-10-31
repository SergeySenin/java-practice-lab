package org.study.javarush.java.core.level16.tasks16.f;

public class Solution311 {
    public static void main(String[] args) {

        DevUtils.printTwice("Java");
        DevUtils.printTwice(100);
    }

    public static class DevUtils {

        public static <T> void printTwice(T item) {
            System.out.println(item);
            System.out.println(item);
        }
    }
}
