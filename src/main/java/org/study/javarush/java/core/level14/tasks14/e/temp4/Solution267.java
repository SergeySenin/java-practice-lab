package org.study.javarush.java.core.level14.tasks14.e.temp4;

public class Solution267 {
    public static void main(String[] args) {

        Student firstStudent = new Student("Анна", "A-101", 90);
        Student secondStudent = new Student("Иван", "B-102");
        Student thirdStudent = new Student("Мария");
        Student fourthStudent = new Student();

        System.out.println("Имя: " + firstStudent.studentName
                + ", группа: " + firstStudent.studentGroup
                + ", балл: " + firstStudent.studentScore);

        System.out.println("Имя: " + secondStudent.studentName
                + ", группа: " + secondStudent.studentGroup
                + ", балл: " + secondStudent.studentScore);

        System.out.println("Имя: " + thirdStudent.studentName
                + ", группа: " + thirdStudent.studentGroup
                + ", балл: " + thirdStudent.studentScore);

        System.out.println("Имя: " + fourthStudent.studentName
                + ", группа: " + fourthStudent.studentGroup
                + ", балл: " + fourthStudent.studentScore);
    }
}
