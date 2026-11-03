package org.study.javarush.java.core.level18.tasks18.f.temp4;

public class Solution351 {
    public static void main(String[] args) {

        Animal[] animals = {new Cat("Мурка"), new Cow("Буренка")};

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}

abstract class Animal {
    protected String name;

    public abstract void makeSound();
}

class Cat extends Animal {
    Cat(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Мяу!");
    }
}

class Cow extends Animal {
    Cow(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Мууу!");
    }
}
