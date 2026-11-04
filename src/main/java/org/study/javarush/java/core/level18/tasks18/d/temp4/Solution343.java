package org.study.javarush.java.core.level18.tasks18.d.temp4;

public class Solution343 {
    public static void main(String[] args) {

        Cat cat = new Cat();

        cat.makeSound();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Животное издаёт звук");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        super.makeSound();
        System.out.println("Мяу!");
    }
}
