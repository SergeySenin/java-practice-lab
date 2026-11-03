package org.study.javarush.java.core.level19.tasks19.d.temp4;

public class Solution363 {
    public static void main(String[] args) {

        Payment[] payments = {
                new CashPayment(),
                new OnlinePayment()
        };

        for (Payment payment : payments) {
            payment.process();
        }
    }
}

abstract class Payment {
    public abstract void process();
}

class CashPayment extends Payment {
    @Override
    public void process() {
        System.out.println("Оплата наличными");
    }
}

class OnlinePayment extends Payment {
    @Override
    public void process() {
        System.out.println("Онлайн-оплата");
    }
}
