package org.study.javarush.java.core.level11.tasks11.e;

public class Solution207 {
    public static void main(String[] args) {

        try {
            convertToGoldAmount("invalid_amount");
        } catch (NumberFormatException exception) {
            System.out.println("Игрок ввел неверное значение. Ошибка преобразования числа.");
        }
    }

    public static int convertToGoldAmount(String playerInput) throws NumberFormatException {

        return Integer.parseInt(playerInput);
    }
}
