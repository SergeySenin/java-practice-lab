package org.study.javarush.java.core.level18.tasks18.e.temp3;

public class Solution346 {
    public static void main(String[] args) {

        Employee[] employees = {new Manager(), new Developer(), new Tester()};

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

class Tester extends Employee {
    @Override
    void work() {
        System.out.println("Тестировщик ищет баги.");
    }
}
