package org.study.javarush.java.core.level19.tasks19.e.temp4;

public class Solution367 {
    public static void main(String[] args) {

        Order[] orders = {
                new OnlineOrder(100.0),
                new OfflineOrder(50.0),
                new OnlineOrder(200.0)
        };

        for (Order order : orders) {
            order.process();
        }
    }
}

abstract class Order {
    protected final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public abstract void process();
}

class OnlineOrder extends Order {
    public OnlineOrder(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.println("Обработка онлайн-заказа на сумму " + amount);
    }
}

class OfflineOrder extends Order {
    public OfflineOrder(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.println("Обработка оффлайн-заказа на сумму " + amount);
    }
}
