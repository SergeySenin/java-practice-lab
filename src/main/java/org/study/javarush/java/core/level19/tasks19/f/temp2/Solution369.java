package org.study.javarush.java.core.level19.tasks19.f.temp2;

import java.util.HashMap;
import java.util.Map;

public class Solution369 {
    public static void main(String[] args) {

        TaskRepository repository = new InMemoryTaskRepository();
        TaskService service = new TaskService(repository);

        service.addTask(new SimpleTask("Подготовить отчёт"));
        service.completeTask("Подготовить отчёт");
    }
}

abstract class Task {
    private final String title;

    public Task(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void complete();
}

class SimpleTask extends Task {
    public SimpleTask(String title) {
        super(title);
    }

    @Override
    public void complete() {
        System.out.println("Задача '" + getTitle() + "' выполнена");
    }
}

interface TaskRepository {
    void save(Task task);

    Task findByTitle(String title);
}

class InMemoryTaskRepository implements TaskRepository {
    private final Map<String, Task> tasks = new HashMap<>();

    @Override
    public void save(Task task) {
        tasks.put(task.getTitle(), task);
    }

    @Override
    public Task findByTitle(String title) {
        return tasks.get(title);
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

    public void completeTask(String title) {
        Task task = repository.findByTitle(title);

        if (task != null) {
            task.complete();
        }
    }
}
