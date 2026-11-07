package org.study.javarush.java.core.level23.tasks23.c.temp4;

public class Solution439 {
    public static void main(String[] args) {

        OverloadDemo demo = new OverloadDemo();

        demo.print(5L);
    }
}

class OverloadDemo {
    public void print(int valueToPrint) {
        System.out.println("int: " + valueToPrint);
    }

    public void print(double valueToPrint) {
        System.out.println("double: " + valueToPrint);
    }
}
