package org.study.javarush.java.core.level23.tasks23.f.temp3;

public class Solution450 {
    private static final double INCOME_TAX_RATE = 0.13;

    public static void main(String[] args) {

        double employeeSalary = 5000.0;

        double calculatedTax = employeeSalary * INCOME_TAX_RATE;

        System.out.println(calculatedTax);
    }
}
