package org.study.javarush.java.core.level16.tasks16.e;

public class Solution306 {
    public static void main(String[] args) {

        SpecialCalculator calculator = new SpecialCalculator();

        calculator.calculateAndDisplaySum(10, 20);
    }
}

class SpecialCalculator {

    public void calculateAndDisplaySum(int numA, int numB) {

        class SumResultPrinter {

            public void printResult() {
                System.out.println(numA + numB);
            }
        }

        SumResultPrinter printer = new SumResultPrinter();
        printer.printResult();
    }
}
