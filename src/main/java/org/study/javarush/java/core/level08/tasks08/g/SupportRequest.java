package org.study.javarush.java.core.level08.tasks08.g;

public class SupportRequest {

    public int requestId;
    public String requestTitle;
    private int priorityLevel;

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

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
