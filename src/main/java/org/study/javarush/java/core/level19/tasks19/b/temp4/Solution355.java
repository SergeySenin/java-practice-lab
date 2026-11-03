package org.study.javarush.java.core.level19.tasks19.b.temp4;

public class Solution355 {
    public static void main(String[] args) {

        PaypalPayment payment = new PaypalPayment();
        payment.printInfo();
        payment.process();
    }
}

abstract class Payment {
    public abstract void process();

    public void printInfo() {
        System.out.println("Платёж обрабатывается");
    }
}

class PaypalPayment extends Payment {
    @Override
    public void process() {
        System.out.println("Обработка платежа через PayPal");
    }
}
