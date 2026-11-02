package org.study.javarush.java.core.level17.tasks17.e.temp3;

public class Solution326 {
    public static void main(String[] args) {

        SchoolStudent student = new SchoolStudent();
        student.introduce();
    }
}

class Person {
    void introduce() {
        System.out.println("Я человек.");
    }
}

class Student extends Person {
}

class SchoolStudent extends Student {
    @Override
    void introduce() {
        System.out.println("Я школьник.");
    }
}
