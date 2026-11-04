package org.study.javarush.java.core.level21.tasks21.b.temp4;

import java.util.function.Function;

public class Solution395 {
    public static void main(String[] args) {

        String prefix = "Результат: ";
        Function<Integer, String> formatter = number -> prefix + (number * 2);

        System.out.println(formatter.apply(7));
    }
}
