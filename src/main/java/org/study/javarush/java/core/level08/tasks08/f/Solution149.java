package org.study.javarush.java.core.level08.tasks08.f;

public class Solution149 {
    public static void main(String[] args) {

        CustomerBankAccount myPrivateAccount = new CustomerBankAccount();

        myPrivateAccount.depositMoney(1000);

        // myPrivateAccount.accountBalance = 2000;
        // accountBalance has private access in CustomerBankAccount
    }
}

class CustomerBankAccount {
    private int accountBalance;

    public void depositMoney(int amountToDeposit) {
        accountBalance += amountToDeposit;
    }
}
