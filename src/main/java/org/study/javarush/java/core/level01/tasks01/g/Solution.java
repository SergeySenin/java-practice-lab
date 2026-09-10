package org.study.javarush.java.core.level01.tasks01.g;

public class Solution {
    public static void main(String[] args) {
        String userName = "Alice";
        String productName = "Mechanical Keyboard";

        int itemPrice = 4800;
        int itemCount = 3;
        int deliveryPrice = 600;
        int discount = 1200;
        int serviceFee = 200;

        int itemsCost;
        itemsCost = itemPrice * itemCount;

        int orderCostBeforeDiscount = (itemsCost + deliveryPrice);

        int discountPerItem = discount / itemCount;

        int totalCost = orderCostBeforeDiscount - discount;
        totalCost = totalCost + serviceFee;

        String finalMessage = "Итого к оплате: " + totalCost + " руб.";

        System.out.print("Покупатель: ");
        System.out.println(userName);

        System.out.print("Товар: ");
        System.out.println(productName);

        System.out.println("Цена за единицу: "      + itemPrice               + " руб.");
        System.out.println("Количество: "           + itemCount);
        System.out.println("Стоимость товаров: "    + itemsCost               + " руб.");
        System.out.println("Доставка: "             + deliveryPrice           + " руб.");
        System.out.println("Стоимость до скидки: "  + orderCostBeforeDiscount + " руб.");
        System.out.println("Скидка: "               + discount                + " руб.");
        System.out.println("Скидка на один товар: " + discountPerItem         + " руб.");
        System.out.println("Сервисный сбор: "       + serviceFee              + " руб.");
        System.out.println(finalMessage);
    }
}
