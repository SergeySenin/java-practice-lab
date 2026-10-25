package org.study.javarush.java.core.level14.tasks14.c;

public class Solution259 {
    public static void main(String[] args) {

        BankAccount firstAccount = new BankAccount("Анна", 1000);
        BankAccount secondAccount = new BankAccount("Иван");

        secondAccount.deposit(500);

        firstAccount.printInfo();
        secondAccount.printInfo();
    }
}

class BankAccount {
    String accountOwner;
    int accountBalance;

    BankAccount(String accountOwner, int accountBalance) {
        this.accountOwner = accountOwner;
        this.accountBalance = accountBalance;
    }

    BankAccount(String accountOwner) {
        this(accountOwner, 0);
    }

    void deposit(int amount) {
        accountBalance += amount;
    }

    void printInfo() {
        System.out.println("Владелец: " + accountOwner + ", баланс: " + accountBalance);
    }
}
