package ru.liamin.vladimir;

import java.io.IOException;
import java.util.Scanner;

/** Class that outputs elements from the matrix to the array */
public class Hatcher {
    /**
     * Method of deriving matrix elements by loop
     * @param args args array of arguments
     * @throws IOException exception required to check file for openness
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Length of matrix: ");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
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
        ArrayTraversal arrayTraversal = new ArrayTraversal();
        int[] elements = new int[matrix.length * matrix.length];
        arrayTraversal.arrayTraversal(matrix, elements);
        System.out.println("Print on concol - 1 \nPrint to file - 2");
        int number = in.nextInt();
        ArrayPrinting arrayPrinting;
        if (number == 1) {
            arrayPrinting = new PrintOnConsole();
            arrayPrinting.print(elements);
        }
        else {
            arrayPrinting = new PrintToFile();
            arrayPrinting.print(elements);
        }

    }
}
