package org.study.javarush.java.core.level19.tasks19.f.temp4;

import java.util.ArrayList;
import java.util.List;

public class Solution371 {
    public static void main(String[] args) {

        TaskRepository repository = new InMemoryTaskRepository();
        TaskService service = new TaskService(repository);

        service.addTask(new WorkTask("Реализовать API", "2026-11-10"));
        service.addTask(new HomeTask("Убрать квартиру", "кухня"));

        service.printAllTasks();
        service.completeAllTasks();
    }
}

abstract class Task {
    protected final String title;

    public Task(String title) {
        this.title = title;
    }

    public abstract String getInfo();

    public abstract void complete();
}

class WorkTask extends Task {
    private final String deadline;

    public WorkTask(String title, String deadline) {
        super(title);
        this.deadline = deadline;
    }

    @Override
    public String getInfo() {
        return "Рабочая задача: " + title + ", срок: " + deadline;
    }

    @Override
    public void complete() {
        System.out.println("Рабочая задача '" + title + "' выполнена");
    }
}

class HomeTask extends Task {
    private final String location;

    public HomeTask(String title, String location) {
        super(title);
        this.location = location;
    }

    @Override
    public String getInfo() {
        return "Домашняя задача: " + title + ", место: " + location;
    }

    @Override
    public void complete() {
        System.out.println("Домашняя задача '" + title + "' выполнена");
    }
}

interface TaskRepository {
    void save(Task task);

    List<Task> findAll();
}

class InMemoryTaskRepository implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public void save(Task task) {
        tasks.add(task);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }
}

class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(Task task) {
        repository.save(task);
    }

    public void printAllTasks() {
        for (Task task : repository.findAll()) {
            System.out.println(task.getInfo());
        }
    }

    public void completeAllTasks() {
        for (Task task : repository.findAll()) {
            task.complete();
        }
    }
}
