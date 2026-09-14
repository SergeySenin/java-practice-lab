package org.study.javarush.java.core.level09.tasks09.f;

public class Solution169 {
    public static void main(String[] args) {

        StringBuilder greetingBuilder = new StringBuilder("Привет, мир!");

        int insertionIndex = greetingBuilder.indexOf(",") + 2;
        greetingBuilder.insert(insertionIndex, "Java ");

        System.out.println(greetingBuilder);
    }
}
