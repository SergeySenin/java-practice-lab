package org.study.javarush.java.core.level21.tasks21.c.temp2;

import java.util.function.Consumer;

public class Solution397 {
    public static void main(String[] args) {

        Consumer<String> messageSender = System.out::println;

        messageSender.accept("Hello, method reference!");
    }
}
