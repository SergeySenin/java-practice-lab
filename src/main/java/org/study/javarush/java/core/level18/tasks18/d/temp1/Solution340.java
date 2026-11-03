package org.study.javarush.java.core.level18.tasks18.d.temp1;

public class Solution340 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.makeSound();
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
        System.out.println("Гав!");
    }
}
