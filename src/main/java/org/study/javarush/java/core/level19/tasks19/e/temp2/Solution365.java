package org.study.javarush.java.core.level19.tasks19.e.temp2;

public class Solution365 {
    public static void main(String[] args) {

        EmailMessage email = new EmailMessage("Привет!");
        SmsMessage sms = new SmsMessage("Привет!");

        email.send();
        sms.send();
    }
}

abstract class Message {
    protected final String text;

    public Message(String text) {
        this.text = text;
    }

    public abstract void send();
}

class EmailMessage extends Message {
    public EmailMessage(String text) {
        super(text);
    }

    @Override
    public void send() {
        System.out.println("Отправка email: " + text);
    }
}

class SmsMessage extends Message {
    public SmsMessage(String text) {
        super(text);
    }

    @Override
    public void send() {
        System.out.println("Отправка SMS: " + text);
    }
}
