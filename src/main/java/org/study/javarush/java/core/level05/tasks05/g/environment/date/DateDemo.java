package org.study.javarush.java.core.level05.tasks05.g.environment.date;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {

        Date javaUtilDate = new Date();
        java.sql.Date javaSqlDate = new java.sql.Date(System.currentTimeMillis());

        System.out.println("java.util.Date: " + javaUtilDate);
        System.out.println("java.sql.Date: "  + javaSqlDate);
    }
}
