package org.study.javarush.java.core.level17.tasks17.c.temp2;

public class Solution317 {
    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.makeSound();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Some animal sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof!");
    }
}
