package ru.liamin.vladimir;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/** Class that outputs elements from the matrix */
public class TransformMatrix {
    /**
     * Application demonstrates the method
     * @param args args array of arguments
     * @throws IOException exception required to check file for openness
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Length of matrix: ");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        if ((length % 2 == 0) && (length > 0))
            throw new IllegalArgumentException("Matrix order must be an odd and positive number");
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = i + j * 2;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Print on concol - 1 \nPrint to file - 2");
        int number = in.nextInt();
        PrintMatrix printMatrix;
        if (number == 1) {
            printMatrix = new PrintToConsole();
        } else {
            printMatrix = new PrintToFile();
        }

        PrintStream printStream = null;
        printMatrix.print(matrix, printStream);
    }
}
