package org.study.javarush.java.core.level21.tasks21.c.temp4;

public class Solution399 {
    public static void main(String[] args) {

        AnimalFactory factory = Animal::new;

        Animal animal = factory.create("Барсик");

        System.out.println(animal.getName());
    }
}

@FunctionalInterface
interface AnimalFactory {
    Animal create(String name);
}

class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
