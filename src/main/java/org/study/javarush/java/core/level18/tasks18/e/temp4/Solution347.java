package org.study.javarush.java.core.level18.tasks18.e.temp4;

public class Solution347 {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee();
        employees[1] = new Manager();
        employees[2] = new Developer();
        employees[3] = new Designer();

        for (Employee employee : employees) {
            if (employee != null) {
                employee.work();
            }
        }

        employees[4] = new Intern();

        for (Employee employee : employees) {
            if (employee != null) {
                employee.work();
            }
        }
    }
}

class Employee {
    void work() {
        System.out.println("Сотрудник работает...");
    }
}

class Manager extends Employee {
    @Override
    void work() {
        System.out.println("Менеджер проводит совещание.");
    }
}

class Developer extends Employee {
    @Override
    void work() {
        System.out.println("Разработчик пишет код.");
    }
}

class Designer extends Employee {
    @Override
    void work() {
        System.out.println("Дизайнер рисует макеты.");
    }
}

class Intern extends Employee {
    @Override
    void work() {
        System.out.println("Стажёр учится работать.");
    }
}
