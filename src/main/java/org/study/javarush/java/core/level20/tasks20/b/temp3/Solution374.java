package org.study.javarush.java.core.level20.tasks20.b.temp3;

public class Solution374 {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.printPi();
    }
}

interface MathConstants {
    double PI = 3.14159;
}

class Calculator {
    public void printPi() {
        System.out.println(MathConstants.PI);
    }
}
