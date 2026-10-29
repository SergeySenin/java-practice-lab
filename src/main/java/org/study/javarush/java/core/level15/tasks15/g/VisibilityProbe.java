package org.study.javarush.java.core.level15.tasks15.g;

public class VisibilityProbe {

    public void showPublicMarker() {
        System.out.println("PUBLIC:    visible");
    }

    protected void showProtectedMarker() {
        System.out.println("PROTECTED: package");
    }

    void showPackageMarker() {
        System.out.println("PACKAGE:   package");
    }

    private void showPrivateMarker() {
        System.out.println("PRIVATE:   internal only");
    }

    public void runInternalCheck() {
        showPrivateMarker();
    }
}
