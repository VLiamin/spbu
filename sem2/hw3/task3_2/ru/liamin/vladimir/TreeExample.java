package ru.liamin.vladimir;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/** Class consider the value of the expression */
public class TreeExample {
    /**
     * Method consider the value of the expression
     * @param args args array of arguments
     * @throws IOException exception required to check file for openness
     */
    public static void main(String[] args) throws IOException {
        Tree tree = new Tree();
        FileReader file = new FileReader("E:\\java\\hw3\\task3_2\\src\\main\\java\\ru\\liamin\\vladimir\\text.txt");
        Scanner scan = new Scanner(file);
        String expression = scan.nextLine();
        file.close();
        char[] ArrayExpression = expression.toCharArray();
        tree.push(ArrayExpression);
        System.out.print("Print tree: ");
        tree.print();
        try {
            System.out.println("\nExpression result: " + tree.count());
        } catch (ArithmeticException e) {
            System.out.println("\nDivision by zero.");
        }
    }
}
