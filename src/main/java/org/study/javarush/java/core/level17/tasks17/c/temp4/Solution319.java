package org.study.javarush.java.core.level17.tasks17.c.temp4;

public class Solution319 {
    public static void main(String[] args) {

        AppleBasket basket = new AppleBasket();

        Fruit harvestedItem = basket.getFruit();

        if (harvestedItem instanceof Apple) {
            System.out.println("Apple created");
        }
    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Basket {
    Fruit getFruit() {
        return new Fruit();
    }
}

class AppleBasket extends Basket {
    @Override
    Apple getFruit() {
        return new Apple();
    }
}
