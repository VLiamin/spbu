package ru.liamin.vladimir;

/** Arithmetic options class */
public class ArithmeticSign {

    private char code;
    private String name;


    public ArithmeticSign(char code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Method returns arithmetic operation
     * @return arithmetic operation
     */
    @Override
    public String toString() {
        return this.name;
    }

}