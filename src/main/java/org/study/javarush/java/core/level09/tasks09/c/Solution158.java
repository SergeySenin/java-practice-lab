package org.study.javarush.java.core.level09.tasks09.c;

import java.util.Locale;

public class Solution158 {
    public static void main(String[] args) {

        String itemName = "Яблоки";
        int itemCount = 7;
        double itemWeight = 1.234;

        String inventoryReport = String.format(
                Locale.US,
                "Товар: [%-10s] | Кол-во: [%4d] | Вес: [%5.2f кг]",
                itemName,
                itemCount,
                itemWeight
        );

        System.out.println(inventoryReport);
    }
}
