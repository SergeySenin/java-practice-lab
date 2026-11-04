package org.study.javarush.java.core.level19.tasks19.f.temp1;

public class Solution368 {
    public static void main(String[] args) {

        Task task = new SimpleTask("Подготовить отчёт");

        task.complete();
    }
}

abstract class Task {
    protected final String title;

    public Task(String title) {
        this.title = title;
    }

    public abstract void complete();
}

class SimpleTask extends Task {
    public SimpleTask(String title) {
        super(title);
    }

    @Override
    public void complete() {
        System.out.println("Задача '" + title + "' выполнена");
    }
}
