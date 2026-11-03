package org.study.javarush.java.core.level18.tasks18.c.temp1;

public class Solution336 {
    public static void main(String[] args) {

        MessagePrinter printer = new MessagePrinter();
        printer.printMessage("Привет, мир!");
        printer.printMessage(10, 20);
    }
}

class MessagePrinter {
    void printMessage(String message) {
        System.out.println(message);
    }

    void printMessage(int first, int second) {
        System.out.println(first + second);
    }
}
