package org.study.javarush.java.core.level15.tasks15.d;

public class Solution283 {
    public static void main(String[] args) {

        SchoolStudent student = new SchoolStudent(10);

        student.setCurrentAge(-5);
        System.out.println(student.getCurrentAge());

        student.setCurrentAge(15);
        System.out.println(student.getCurrentAge());
    }
}

class SchoolStudent {
    private int currentAge;

    public SchoolStudent(int currentAge) {
        this.currentAge = currentAge;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int potentialAge) {
        if (potentialAge < 0) {
            System.out.println("Внимание! Возраст студента не может быть отрицательным. Значение не обновлено.");
            return;
        }

        this.currentAge = potentialAge;
    }
}
