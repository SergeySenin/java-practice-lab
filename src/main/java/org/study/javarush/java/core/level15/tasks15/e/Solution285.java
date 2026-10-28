package org.study.javarush.java.core.level15.tasks15.e;

public class Solution285 {
    public static void main(String[] args) {

        StudentIdentityCard card = new StudentIdentityCard("Алиса");

        System.out.println(card.getStudentName());
    }
}

class StudentIdentityCard {
    private final String studentName;

    public StudentIdentityCard(String initialName) {
        this.studentName = initialName;
    }

    public String getStudentName() {
        return studentName;
    }
}
