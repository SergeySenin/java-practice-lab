package org.study.javarush.java.core.level01.tasks01.g;

public class Solution {
    public static void main(String[] args) {

        String customerName = "Alice";
        String productName = "Mechanical Keyboard";

        int itemUnitPrice = 4800;
        int itemCount = 3;
        int deliveryFee = 600;
        int orderDiscount = 1200;
        int serviceFee = 200;

        int totalItemsCost;
        totalItemsCost = itemUnitPrice * itemCount;

        int orderCostBeforeDiscount = (totalItemsCost + deliveryFee);

        int discountPerItem = orderDiscount / itemCount;

        int totalOrderCost = orderCostBeforeDiscount - orderDiscount;
        totalOrderCost = totalOrderCost + serviceFee;

        String orderTotalMessage = "Итого к оплате: " + totalOrderCost + " руб.";

        System.out.print("Покупатель: ");
        System.out.println(customerName);

        System.out.print("Товар: ");
        System.out.println(productName);

        System.out.println("Цена за единицу: "      + itemUnitPrice           + " руб.");
        System.out.println("Количество: "           + itemCount);
        System.out.println("Стоимость товаров: "    + totalItemsCost          + " руб.");
        System.out.println("Доставка: "             + deliveryFee             + " руб.");
        System.out.println("Стоимость до скидки: "  + orderCostBeforeDiscount + " руб.");
        System.out.println("Скидка: "               + orderDiscount           + " руб.");
        System.out.println("Скидка на один товар: " + discountPerItem         + " руб.");
        System.out.println("Сервисный сбор: "       + serviceFee              + " руб.");
        System.out.println(orderTotalMessage);
    }
}
