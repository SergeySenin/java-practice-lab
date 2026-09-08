package org.study.javarush.java.core.level06.tasks06.e;

public class Solution105 {
    public static void main(String[] args) {

        double elixirPriceWithTax = 17.34567;

        double displayPrice = Math.round(elixirPriceWithTax * 100) / 100.0;

        System.out.println(displayPrice);
    }
}
