package org.study.javarush.java.core.level23.tasks23.c.temp2;

public class Solution437 {
    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.makeSound();
        dog.makeSound("громко");
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    public void makeSound(String intensity) {
        System.out.println("Bark! " + intensity);
    }
}
