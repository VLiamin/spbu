package ru.liamin.vladimir;

import java.io.PrintStream;

/** Class designed to display items on the console */
public class PrintToConsole implements PrintMatrix {

    /**
     * Displays the elements of the matrix to the console
     * @param matrix of elements that need to be rewritten
     */
    public void print(int[][] matrix) {

        PrintStream printStream = new PrintStream(System.out);
        BuildSpiral.walkAroundTheMatrix(matrix, printStream);
    }
}
