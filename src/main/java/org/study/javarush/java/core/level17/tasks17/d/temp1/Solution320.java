package org.study.javarush.java.core.level17.tasks17.d.temp1;

public class Solution320 {
    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.makeSound();
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("Собака лает");
    }
}
