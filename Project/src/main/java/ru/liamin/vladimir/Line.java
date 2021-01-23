package ru.liamin.vladimir;

import java.util.List;

public class Line {

    private String word;
    private int weight;

    public Line(String word) {
        this.word = word;
    }

    public String getLine() {
        return word;
    }

    public void addWeight() {
        weight++;
    }

    private int getWeight() {
        return weight;
    }
}
