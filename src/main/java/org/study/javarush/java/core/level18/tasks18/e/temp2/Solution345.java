package org.study.javarush.java.core.level18.tasks18.e.temp2;

public class Solution345 {
    public static void main(String[] args) {

        Employee[] employees = {new Manager(), new Developer()};

        for (Employee employee : employees) {
            employee.work();
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
