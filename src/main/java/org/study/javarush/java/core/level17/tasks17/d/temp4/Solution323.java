package org.study.javarush.java.core.level17.tasks17.d.temp4;

public class Solution323 {
    public static void main(String[] args) {

        Student student = new Student("Анна", 3);
    }
}

class Person {
    Person(String humanName) {
        System.out.println("Создан человек: " + humanName);
    }
}

class Student extends Person {
    Student(String studentName, int studentGrade) {
        super(studentName);
        System.out.println("Создан студент: " + studentName + ", класс: " + studentGrade);
    }
}
