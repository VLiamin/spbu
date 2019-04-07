package ru.liamin.vladimir;

public class ArithmeticSign {

    private char code;
    private String name;


    public ArithmeticSign(char code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}