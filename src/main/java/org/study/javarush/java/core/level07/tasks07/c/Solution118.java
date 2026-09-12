package org.study.javarush.java.core.level07.tasks07.c;

public class Solution118 {
    public static void main(String[] args) {

        int[] itemPrices = {5, 7, 2, 9};
        int totalPrice = 0;

        for (int itemPrice : itemPrices) {
            totalPrice += itemPrice;
        }

        System.out.println(totalPrice);
    }
}
