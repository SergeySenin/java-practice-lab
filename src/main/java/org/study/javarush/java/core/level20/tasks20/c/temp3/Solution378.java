package org.study.javarush.java.core.level20.tasks20.c.temp3;

public class Solution378 {
    public static void main(String[] args) {
        MultiFunctionDevice device = new MultiFunctionDevice();
        device.print();
        device.scan();
    }
}

interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

class MultiFunctionDevice implements Printable, Scannable {
    @Override
    public void print() {
        System.out.println("Печать...");
    }

    @Override
    public void scan() {
        System.out.println("Сканирование...");
    }
}
