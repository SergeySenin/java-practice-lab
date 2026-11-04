package org.study.javarush.java.core.level21.tasks21.d.temp3;

public class Solution402 {
    public static void main(String[] args) {

        ConsolePrinter printer = new ConsolePrinter();

        printer.printTwice("Java");
    }
}

interface Printer {
    void print(String message);

    default void printTwice(String message) {
        print(message);
        print(message);
    }
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
