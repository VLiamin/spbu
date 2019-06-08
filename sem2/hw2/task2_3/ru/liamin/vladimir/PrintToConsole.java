package ru.liamin.vladimir;

import java.io.IOException;
import java.io.PrintStream;

/** Class designed to display items on the console */
public class PrintToConsole extends BuildSpiral {

    /**
     * Displays the elements of the matrix to the console
     * @param matrix of elements that need to be rewritten
     */
    public void print(int[][] matrix, PrintStream printStream) throws IOException {
        printStream = new PrintStream(System.out);
        super.print(matrix, printStream);
    }
}
