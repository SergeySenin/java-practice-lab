package org.study.javarush.java.core.level21.tasks21.e.temp3;

public class Solution406 {
    public static void main(String[] args) {

        NumberPrinter printer = new NumberPrinter();

        printer.printSquare(5);
        MathHelper.printCube(5);
    }
}

interface MathHelper {
    default void printSquare(int number) {
        System.out.println(number * number);
    }

    static void printCube(int number) {
        System.out.println(number * number * number);
    }
}

class NumberPrinter implements MathHelper {
}
