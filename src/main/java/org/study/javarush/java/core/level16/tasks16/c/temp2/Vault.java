package org.study.javarush.java.core.level16.tasks16.c.temp2;

public class Vault {
    private static int securityLevel = 100;

    public static class SecurityDisplayUnit {
        public void showSecurityLevel() {
            System.out.println(Vault.securityLevel);
        }
    }
}
