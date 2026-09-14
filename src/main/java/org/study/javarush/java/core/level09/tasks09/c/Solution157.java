package org.study.javarush.java.core.level09.tasks09.c;

import java.util.Locale;

public class Solution157 {
    public static void main(String[] args) {

        double productPrice = 123.456;

        String formattedPrice = String.format(
                Locale.US,
                "Цена: %.2f евро.",
                productPrice
        );

        System.out.println(formattedPrice);
    }
}
