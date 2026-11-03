package org.study.javarush.java.core.level18.tasks18.f.temp3;

public class Solution350 {
    public static void main(String[] args) {

        Employee[] employees = {new Manager(), new Developer()};

        for (Employee employee : employees) {
            employee.work();
        }
    }
}

abstract class Employee {
    public abstract void work();
}

class Manager extends Employee {
    @Override
    public void work() {
        System.out.println("Менеджер управляет проектами.");
    }
}

class Developer extends Employee {
    @Override
    public void work() {
        System.out.println("Разработчик пишет код.");
    }
}
