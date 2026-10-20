package org.study.javarush.java.core.level12.tasks12.c;

import java.util.HashMap;

public class Solution217 {
    public static void main(String[] args) {

        HashMap<String, Integer> studentGrades = new HashMap<>();

        studentGrades.put("Анна", 5);

        if (studentGrades.containsKey("Анна")) {
            System.out.println("Оценка Анны: " + studentGrades.get("Анна"));
        }
    }
}
