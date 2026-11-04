package org.study.javarush.java.core.level20.tasks20.b.temp4;

public class Solution375 {
    public static void main(String[] args) {
        Soundable[] animals = {new Dog(), new Cat()};

        for (Soundable animal : animals) {
            animal.makeSound();
        }
    }
}

interface Soundable {
    void makeSound();
}

class Dog implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
