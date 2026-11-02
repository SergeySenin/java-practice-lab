package org.study.javarush.java.core.level17.tasks17.f.temp3;

public class Solution330 {
    public static void main(String[] args) {

        Student student = new Student("Елена");
    }
}

class Person {
    Person(String humanName) {
        System.out.println("Person создан: " + humanName);
    }
}

class Student extends Person {
    Student(String studentName) {
        super(studentName);
        System.out.println("Student создан: " + studentName);
    }
}
