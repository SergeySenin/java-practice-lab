package org.study.javarush.java.core.level21.tasks21.c.temp1;

import java.util.function.IntFunction;

public class Solution396 {
    public static void main(String[] args) {

        IntFunction<String> converter = Integer::toHexString;

        System.out.println(converter.apply(255));
    }
}
