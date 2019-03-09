package ru.liamin.vladimir;

public interface Stack {
    void push(char value);
    char pop();
    boolean isEmpty();
    int count();
    void printStack();
    boolean isPlusOrMinus();
    void clear();

}
