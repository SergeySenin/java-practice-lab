package org.study.javarush.java.core.level21.tasks21.e.temp2;

public class Solution405 {
    public static void main(String[] args) {

        ConsolePrinter printer = new ConsolePrinter();

        Printer.printHello(printer);
    }
}

interface Printer {
    void print(String text);

    static void printHello(Printer printer) {
        printer.print("Hello, world!");
    }
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
