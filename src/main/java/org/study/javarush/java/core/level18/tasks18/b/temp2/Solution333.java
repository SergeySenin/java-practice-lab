package org.study.javarush.java.core.level18.tasks18.b.temp2;

public class Solution333 {
    public static void main(String[] args) {

        Animal[] animals = {new Cat(), new Cow()};

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}

class Animal {
    void makeSound() {
        System.out.println("Какой-то звук...");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Мяу!");
    }
}

class Cow extends Animal {
    @Override
    void makeSound() {
        System.out.println("Мууу!");
    }
}
