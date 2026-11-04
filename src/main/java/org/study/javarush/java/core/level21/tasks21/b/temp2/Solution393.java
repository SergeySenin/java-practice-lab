package org.study.javarush.java.core.level21.tasks21.b.temp2;

import java.util.function.Consumer;

public class Solution393 {
    public static void main(String[] args) {

        Consumer<String> textHandler = text -> System.out.println(text.toUpperCase());

        textHandler.accept("java");
    }
}
