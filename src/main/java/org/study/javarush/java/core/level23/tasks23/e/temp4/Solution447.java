package org.study.javarush.java.core.level23.tasks23.e.temp4;

public class Solution447 {
    public static void main(String[] args) {

        Programmer programmer = new Programmer("Анна");

        programmer.work();
        programmer.report();
    }
}

abstract class Worker {
    protected String employeeName;

    protected Worker(String employeeName) {
        this.employeeName = employeeName;
    }

    public abstract void work();
}

interface Reportable {
    void report();
}

class Programmer extends Worker implements Reportable {
    public Programmer(String employeeName) {
        super(employeeName);
    }

    @Override
    public void work() {
        System.out.println("Программист пишет код");
    }

    @Override
    public void report() {
        System.out.println("Программист сдаёт отчёт");
    }
}
