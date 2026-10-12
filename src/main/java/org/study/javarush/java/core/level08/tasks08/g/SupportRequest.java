package org.study.javarush.java.core.level08.tasks08.g;

public class SupportRequest {

    public int requestId;
    public String requestTitle;
    // Из другого класса приоритет доступен только через публичные методы.
    private int priorityLevel;

    public void setPriorityLevel(int priorityLevel) {
        // this.priorityLevel — поле объекта, priorityLevel — одноимённый параметр метода.
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    // Приватный метод доступен внутри SupportRequest: его вызывает printRequestProfile().
    private String getPriorityLabel() {
        if (priorityLevel == 3) {
            return "CRITICAL";
        } else if (priorityLevel == 2) {
            return "MEDIUM";
        } else if (priorityLevel == 1) {
            return "NORMAL";
        } else {
            return "UNKNOWN";
        }
    }

    public void printRequestProfile() {
        System.out.println("ID:             " + requestId);
        System.out.println("Title:          " + requestTitle);
        System.out.println("Priority:       " + priorityLevel);
        System.out.println("Priority label: " + getPriorityLabel());
    }
}
