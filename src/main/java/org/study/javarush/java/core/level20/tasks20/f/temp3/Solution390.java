package org.study.javarush.java.core.level20.tasks20.f.temp3;

public class Solution390 {
    public static void main(String[] args) {

        Greeter greeter = new Greeter();

        greeter.setStrategy(new FriendlyGreeting());
        greeter.greet("Вася");

        greeter.setStrategy(new FormalGreeting());
        greeter.greet("Вася");
    }
}

interface GreetingStrategy {
    void greet(String name);
}

class FriendlyGreeting implements GreetingStrategy {
    @Override
    public void greet(String name) {
        System.out.println("Привет, " + name + "!");
    }
}

class FormalGreeting implements GreetingStrategy {
    @Override
    public void greet(String name) {
        System.out.println("Здравствуйте, " + name + ".");
    }
}

class Greeter {
    private GreetingStrategy strategy;

    public void setStrategy(GreetingStrategy strategy) {
        this.strategy = strategy;
    }

    public void greet(String name) {
        strategy.greet(name);
    }
}
