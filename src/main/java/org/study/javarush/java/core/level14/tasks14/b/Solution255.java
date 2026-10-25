package org.study.javarush.java.core.level14.tasks14.b;

public class Solution255 {
    public static void main(String[] args) {

        Student firstStudent = new Student();
        firstStudent.studentName = "Анна";
        firstStudent.enrollmentYear = 2022;

        Student secondStudent = new Student();
        secondStudent.studentName = "Иван";
        secondStudent.enrollmentYear = 2023;

        System.out.println("Имя: " + firstStudent.studentName + ", год поступления: " + firstStudent.enrollmentYear);

        System.out.println("Имя: " + secondStudent.studentName + ", год поступления: " + secondStudent.enrollmentYear);
    }
}

class Student {
    String studentName;
    int enrollmentYear;
}
