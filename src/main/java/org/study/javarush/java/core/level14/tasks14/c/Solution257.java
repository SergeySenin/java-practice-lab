package org.study.javarush.java.core.level14.tasks14.c;

public class Solution257 {
    public static void main(String[] args) {

        Student student = new Student("Анна", 5);

        System.out.println("Имя: " + student.studentName + ", оценка: " + student.studentGrade);
    }
}

class Student {
    String studentName;
    int studentGrade;

    Student(String studentName, int studentGrade) {
        this.studentName = studentName;
        this.studentGrade = studentGrade;
    }
}
