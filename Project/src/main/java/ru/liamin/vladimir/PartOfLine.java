package ru.liamin.vladimir;

public class PartOfLine {

    private String word;
    private boolean isOperator;
    private boolean isReturn;

    public PartOfLine(String word, boolean isOperator, boolean isReturn) {
        this.word = word;
        this.isOperator = isOperator;
        this.isReturn = isReturn;
    }
    public String getWord() {
        return word;
    }

    public boolean isOperator() {
        return isOperator;
    }

    public boolean isReturn() {
        return isReturn;
    }
}

