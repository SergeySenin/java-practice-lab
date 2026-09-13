package org.study.javarush.java.core.level08.tasks08.e;

public class Solution147 { // MagicalContainer в Solution147 → иотклонение от условия задачи
    public static void main(String[] args) {

        MagicalContainer myTreasureChest = new MagicalContainer();
        myTreasureChest.magicValue = 15;

        attemptToEnchantContainer(myTreasureChest);

        System.out.println(myTreasureChest.magicValue);
    }

    public static void attemptToEnchantContainer(MagicalContainer containerToEnchant) {
        containerToEnchant.magicValue = 99;

        containerToEnchant = new MagicalContainer();
        containerToEnchant.magicValue = 42;
    }

    public static class MagicalContainer {
        public int magicValue;
    }
}
