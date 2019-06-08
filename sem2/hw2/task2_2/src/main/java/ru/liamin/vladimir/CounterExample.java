package ru.liamin.vladimir;

import java.util.Scanner;

public class CounterExample {
    /**
     * Enters the expression and displays the value
     * @param args args array of arguments
     */
    public static void main(String[] args) {
        Scanner ch = new Scanner(System.in);
        System.out.println("Your expression: ");
        String expression = ch.nextLine();
        Stack stack;
        stack = new StackArray(expression.length());
        System.out.println("Stack by array: ");
        Calculate calculate = new Calculate(stack);
        char[] copyExpression = new char[expression.length()];
        for (int i = 0; i < expression.length(); i++) {
            copyExpression[i] = expression.charAt(i);
        }
        System.out.println(calculate.calculate(copyExpression));
        stack = new StackPointer();
        System.out.println("Stack by pointer: ");
        calculate = new Calculate(stack);
        for (int i = 0; i < expression.length(); i++) {
            copyExpression[i] = expression.charAt(i);
        }
        System.out.println(calculate.calculate(copyExpression));

    }
}
