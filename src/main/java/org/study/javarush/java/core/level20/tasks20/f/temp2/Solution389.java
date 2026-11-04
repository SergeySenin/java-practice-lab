package org.study.javarush.java.core.level20.tasks20.f.temp2;

public class Solution389 {
    public static void main(String[] args) {
        MessageSender sender = new EmailSender();
        Notification notification = new Notification(sender);
        notification.notifyUser("Привет!");
    }
}

interface MessageSender {
    void send(String text);
}

class EmailSender implements MessageSender {
    @Override
    public void send(String text) {
        System.out.println("Email отправлен: " + text);
    }
}

class Notification {
    private final MessageSender sender;

    public Notification(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String text) {
        sender.send(text);
    }
}
