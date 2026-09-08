package org.study.javarush.java.core.level06.tasks06.c;

public class Solution98 {
    public static void main(String[] args) {

        double productPrice = 1234.56789;

        String formattedPrice = String.format(
                java.util.Locale.US,
                "%.2f",
                productPrice
        );

        System.out.println(formattedPrice);
    }
}
