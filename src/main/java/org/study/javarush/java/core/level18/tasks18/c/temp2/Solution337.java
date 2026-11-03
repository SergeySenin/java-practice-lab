package org.study.javarush.java.core.level18.tasks18.c.temp2;

public class Solution337 {
    public static void main(String[] args) {

        Multiplier multiplier = new Multiplier();
        System.out.println(multiplier.multiply(5, 4));
        System.out.println(multiplier.multiply(2.5, 3.0));
    }
}

class Multiplier {
    int multiply(int first, int second) {
        return first * second;
    }

    double multiply(double first, double second) {
        return first * second;
    }
}
