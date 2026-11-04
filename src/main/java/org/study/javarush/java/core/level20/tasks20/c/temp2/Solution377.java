package org.study.javarush.java.core.level20.tasks20.c.temp2;

public class Solution377 {
    public static void main(String[] args) {
        Student student = new Student("Анна");
        student.printInfo();
    }
}

interface Identifiable {
    public static final int ID = 42;
}

abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person implements Identifiable {
    public Student(String name) {
        super(name);
    }

    public void printInfo() {
        System.out.println("Имя: " + name + ", ID: " + ID);
    }
}
