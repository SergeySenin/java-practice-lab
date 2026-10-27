package org.study.javarush.java.core.level11.tasks11.g;

public class ExceptionTraceDemo {

    public static void demonstrateHandledArithmeticException() {
        int numerator   = 100;
        int denominator = 0;

        try {
            int divisionResult = numerator / denominator;

        } catch (ArithmeticException exception) {
            System.out.println("HANDLED ARITHMETIC ERROR: " + exception.getMessage());
        }

        System.out.println("EXECUTION CONTINUED");
    }

    public static void runDiagnosticChain() {
        triggerDiagnosticFailure();
    }

    public static void triggerDiagnosticFailure() {
        int numerator   = 100;
        int denominator = 0;

        int divisionResult = numerator / denominator;
    }

    public static void main(String[] args) {
        demonstrateHandledArithmeticException();

        try {
            runDiagnosticChain();

        } finally {
            System.out.println("DIAGNOSTIC FINISHED");
        }
    }
}
