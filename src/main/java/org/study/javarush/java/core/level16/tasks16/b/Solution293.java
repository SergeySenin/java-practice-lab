package org.study.javarush.java.core.level16.tasks16.b;

public class Solution293 {
    public static void main(String[] args) {

        Person person = new Person("Anna");
        Person.Greeting greeting = person.new Greeting();

        greeting.sayHello();
    }
}

class Person {
    private String userName;

    public Person(String userName) {
        this.userName = userName;
    }

    class Greeting {
        public void sayHello() {
            System.out.println("Hello, " + userName);
        }
    }
}
