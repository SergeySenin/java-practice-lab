package org.study.javarush.java.core.level18.tasks18.b.temp1;

public class Solution332 {
    public static void main(String[] args) {

        Animal animal = new Dog();
        animal.makeSound();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Какой-то звук...");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Гав!");
    }
}
