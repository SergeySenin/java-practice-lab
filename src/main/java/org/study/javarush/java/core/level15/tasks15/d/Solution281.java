package org.study.javarush.java.core.level15.tasks15.d;

public class Solution281 {
    public static void main(String[] args) {

        StudentProfile student = new StudentProfile(18);

        student.setStudentAge(20);

        System.out.println(student.getStudentAge());
    }
}

class StudentProfile {
    private int studentAge;

    public StudentProfile(int studentAge) {
        this.studentAge = studentAge;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int newAge) {
        this.studentAge = newAge;
    }
}
