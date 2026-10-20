package org.study.javarush.java.core.level12.tasks12.b;

import java.util.ArrayList;
import java.util.List;

public class Solution212 {
    public static void main(String[] args) {

        List<Integer> artifactIds = new ArrayList<>();

        artifactIds.add(42);

        int firstArtifactId = artifactIds.get(0);

        System.out.println(firstArtifactId);
    }
}
