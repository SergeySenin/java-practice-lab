package org.study.javarush.java.core.level18.tasks18.d.temp2;

public class Solution341 {
    public static void main(String[] args) {

        ColorPrinter printer = new ColorPrinter();

        printer.print(5);
        printer.print("Hello");
    }
}

class Printer {
    void print(int number) {
        System.out.println("Число: " + number);
    }

    void print(String text) {
        System.out.println("Строка: " + text);
    }
}

class ColorPrinter extends Printer {
    @Override
    void print(String text) {
        System.out.println("Цветная строка: " + text);
    }
}
