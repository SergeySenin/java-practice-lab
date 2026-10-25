package org.study.javarush.java.core.level14.tasks14.f;

public class Solution268 {
    public static void main(String[] args) {

        Animal wildAnimal = new Animal();

        System.out.println(wildAnimal.animalAge);
        System.out.println(wildAnimal.animalName);
    }
}

class Animal {
    int animalAge;
    String animalName;
}
