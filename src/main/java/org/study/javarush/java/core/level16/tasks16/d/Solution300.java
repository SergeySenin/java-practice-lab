package org.study.javarush.java.core.level16.tasks16.d;

public class Solution300 {
    public static void main(String[] args) {

        MagicalCreature creature = new MagicalCreature() {
            @Override
            public void makeSound() {
                System.out.println("Ква-ква!");
            }
        };

        creature.makeSound();
    }
}

class MagicalCreature {
    public void makeSound() {
        System.out.println("Существо издаёт звук");
    }
}
