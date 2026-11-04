package org.study.javarush.java.core.level20.tasks20.d.temp1;

public class Solution380 {
    public static void main(String[] args) {

        Sketch sketch = new Sketch();

        sketch.draw();
        sketch.erase();
    }
}

interface Drawable {
    void draw();
}

interface Erasable {
    void erase();
}

class Sketch implements Drawable, Erasable {
    @Override
    public void draw() {
        System.out.println("Рисунок создан");
    }

    @Override
    public void erase() {
        System.out.println("Рисунок стёрт");
    }
}
