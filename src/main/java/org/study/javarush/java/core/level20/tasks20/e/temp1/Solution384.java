package org.study.javarush.java.core.level20.tasks20.e.temp1;

public class Solution384 {
    public static void main(String[] args) {
        MessagePrinter printer = message -> System.out.println(message);
        printer.print("Привет, Java!");
    }
}

@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}
