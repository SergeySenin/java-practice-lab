package org.study.javarush.java.core.level08.tasks08.c;

public class Solution138 {
    public static void main(String[] args) { // main не в HRProfileManager → отклонение от условия задачи

        HRProfileManager.displayEmployeeCard("Олег", 30);
    }

    public class HRProfileManager {
        public static void displayEmployeeCard(String employeeName, int employeeAge) {
            System.out.println("Имя сотрудника: " + employeeName + ", Возраст: " + employeeAge);
        }
    }
}
