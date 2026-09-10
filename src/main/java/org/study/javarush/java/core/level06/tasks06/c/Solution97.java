package org.study.javarush.java.core.level06.tasks06.c;

import java.util.Locale;
import java.util.Scanner;

public class Solution97 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        console.useLocale(Locale.US);

        double customerPayment = console.nextDouble();

        System.out.println("Внесено средств: " + customerPayment);
    }
}
