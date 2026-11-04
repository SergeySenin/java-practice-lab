package org.study.javarush.java.core.level20.tasks20.e.temp4;

public class Solution387 {
    public static void main(String[] args) {

        StringTransformer transformer = text -> text.toLowerCase();

        transformer.printTransformed("JAVA ROCKS");
    }
}

@FunctionalInterface
interface StringTransformer {
    String transform(String s);

    default void printTransformed(String s) {
        System.out.println(transform(s));
    }
}
