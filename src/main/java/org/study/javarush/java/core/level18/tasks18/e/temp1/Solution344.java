package org.study.javarush.java.core.level18.tasks18.e.temp1;

public class Solution344 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.makeSound();
        cat.makeSound();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Животное издаёт звук");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Собака лает");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Кошка мяукает");
    }
}
