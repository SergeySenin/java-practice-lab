package org.study.javarush.java.core.level21.tasks21.f.temp1;

public class NumberBox implements Comparable<NumberBox> {
    private final int value;

    public NumberBox(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(NumberBox other) {
        return Integer.compare(this.value, other.value);
    }
}
