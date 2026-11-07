package org.study.javarush.java.core.level08.tasks08.c;

public class Solution137 {
    public static void main(String[] args) {

        StoreCashier.calculateAndShowCost(7, 5);
    }

    public class StoreCashier {
        public static void calculateAndShowCost(int firstItemPrice, int secondItemPrice) {
            System.out.println("Общая стоимость покупки: " + (firstItemPrice + secondItemPrice));
        }
    }
}
