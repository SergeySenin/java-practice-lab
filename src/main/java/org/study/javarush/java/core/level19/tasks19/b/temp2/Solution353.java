package org.study.javarush.java.core.level19.tasks19.b.temp2;

public class Solution353 {
    public static void main(String[] args) {

        Animal dog = new Dog();
        dog.makeSound();
    }
}

abstract class Animal {
    public abstract void makeSound();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}
