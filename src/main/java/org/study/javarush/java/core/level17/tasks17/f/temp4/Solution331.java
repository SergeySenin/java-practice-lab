package org.study.javarush.java.core.level17.tasks17.f.temp4;

public class Solution331 {
    public static void main(String[] args) {

        Animal mysteriousCreature = new Cat();
        mysteriousCreature.sleep();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }

    void sleep() {
        System.out.println("Animal is going to sleep...");
        this.makeSound();
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}
