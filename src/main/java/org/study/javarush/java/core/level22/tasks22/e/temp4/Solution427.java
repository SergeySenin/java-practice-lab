package org.study.javarush.java.core.level22.tasks22.e.temp4;

public class Solution427 {
    public static void main(String[] args) {

        Transaction validTransaction = new Transaction("Анна", "Иван", 1000.0);

        System.out.println(validTransaction.description());

        new Transaction("Анна", "Иван", -100.0);
    }
}

record Transaction(String sender, String recipient, double amount) {
    public Transaction {
        if (!(amount > 0)) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше нуля: " + amount);
        }
        if (sender == null || sender.isBlank() || recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Отправитель и получатель должны быть указаны");
        }
    }

    public String description() {
        return "Перевод " + amount + " от " + sender + " к " + recipient;
    }
}
