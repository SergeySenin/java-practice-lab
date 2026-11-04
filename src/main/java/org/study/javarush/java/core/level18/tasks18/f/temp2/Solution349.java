package org.study.javarush.java.core.level18.tasks18.f.temp2;

public class Solution349 {
    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.makeSound();
    }
}

abstract class Animal {
    public abstract void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }
}
