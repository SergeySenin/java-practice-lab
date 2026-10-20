package org.study.javarush.java.core.level12.tasks12.c;

import java.util.HashMap;

public class Solution218 {
    public static void main(String[] args) {

        HashMap<Integer, String> userRegistry = new HashMap<>();

        userRegistry.put(1, "Иван");
        userRegistry.put(2, "Мария");

        userRegistry.remove(1);

        System.out.println(userRegistry.get(1));
    }
}
