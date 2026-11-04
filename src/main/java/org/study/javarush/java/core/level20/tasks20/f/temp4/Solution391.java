package org.study.javarush.java.core.level20.tasks20.f.temp4;

import java.util.ArrayList;
import java.util.List;

public class Solution391 {
    public static void main(String[] args) {

        NewsPublisher publisher = new NewsPublisher();
        Person first = new Person("Анна");
        Person second = new Person("Иван");

        publisher.addSubscriber(first);
        publisher.addSubscriber(second);

        publisher.notifySubscribers("Обновление курса Java!");
    }
}

interface Subscriber {
    void update(String news);
}

class NewsPublisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

class Person implements Subscriber {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " получил новость: " + news);
    }
}
