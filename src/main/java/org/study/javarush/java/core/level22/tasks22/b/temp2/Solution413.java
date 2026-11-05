package org.study.javarush.java.core.level22.tasks22.b.temp2;

public class Solution413 {
    public static void main(String[] args) {

        Student student = new Student("Анна", 20);

        System.out.println(student.name());
        System.out.println(student.age());
    }
}

record Student(String name, int age) {
}
