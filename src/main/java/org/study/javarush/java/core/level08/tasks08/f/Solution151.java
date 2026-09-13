package org.study.javarush.java.core.level08.tasks08.f;

public class Solution151 {
    public static void main(String[] args) {

        SchoolStudent newPupil = new SchoolStudent();

        newPupil.studentName = "Мария";

        newPupil.setStudentAge(16);

        // newPupil.studentAge = 18;
        // studentAge has private access in SchoolStudent

        newPupil.displayStudentProfile();
    }
}

class SchoolStudent {
    public String studentName;
    private int studentAge;

    public void setStudentAge(int ageToSet) {
        studentAge = ageToSet;
    }

    public void displayStudentProfile() {
        System.out.println(studentName);
        System.out.println(studentAge);
    }
}
