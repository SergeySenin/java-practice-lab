package org.study.javarush.java.core.level06.tasks06.d;

public class Solution103 {
    public static void main(String[] args) {

        double actualFrequency = 0.1 + 0.2;
        double targetFrequency = 0.3;
        double tolerance = 0.000001;

        if (Math.abs(actualFrequency - targetFrequency) < tolerance) {
            System.out.println("Лазер откалиброван с допустимой точностью");
        } else {
            System.out.println("Требуется дополнительная калибровка");
        }
    }
}
