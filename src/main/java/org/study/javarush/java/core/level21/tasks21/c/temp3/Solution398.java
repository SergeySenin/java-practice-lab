package org.study.javarush.java.core.level21.tasks21.c.temp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution398 {
    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>(Arrays.asList("яблоко", "банан", "груша"));

        fruits.sort(String::compareTo);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
