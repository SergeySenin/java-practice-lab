package org.study.javarush.java.core.level11.tasks11.c;

public class Solution197 {
    public static void main(String[] args) {

        int[] heroInventory = {101, 102, 103};

        try {
            System.out.println(heroInventory[10]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Ошибка! Такой ячейки в рюкзаке не существует. Индекс вне границ массива.");
        }
    }
}
