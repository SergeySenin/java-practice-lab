package org.study.javarush.java.core.level12.tasks12.b;

import java.util.ArrayList;
import java.util.List;

public class Solution213 {
    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Апельсин");

        fruits.set(1, "Груша");

        fruits.remove(0);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
