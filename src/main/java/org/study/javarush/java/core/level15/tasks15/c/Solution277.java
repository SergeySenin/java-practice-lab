package org.study.javarush.java.core.level15.tasks15.c;

public class Solution277 {
    public static void main(String[] args) {

        MagicCalculator calculator = new MagicCalculator();

        int result = calculator.addNumbers(10, 15);

        System.out.println(result);

        // Ошибка компиляции при раскомментировании:
        // calculator.displayInternalResult(result);
    }
}

class MagicCalculator {

    public int addNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private void displayInternalResult(int calculationResult) {
        System.out.println("Внутренний результат: " + calculationResult);
    }
}
