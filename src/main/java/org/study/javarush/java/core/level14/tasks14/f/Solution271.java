package org.study.javarush.java.core.level14.tasks14.f;

public class Solution271 {
    public static void main(String[] args) {

        Student newStudent = new Student();
    }
}

class Student {
    int studentGrade = 1;

    {
        System.out.println("Блок 1: grade = " + studentGrade);
        studentGrade = 5;
    }

    {
        System.out.println("Блок 2: grade = " + studentGrade);
    }
}
