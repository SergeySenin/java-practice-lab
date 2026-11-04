package org.study.javarush.java.core.level21.tasks21.d.temp2;

public class Solution401 {
    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.voice();
        dog.sleep();
    }
}

interface Animal {
    void voice();

    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog implements Animal {
    @Override
    public void voice() {
        System.out.println("Woof");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}
