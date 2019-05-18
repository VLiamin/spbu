package ru.liamin.vladimir;

import java.io.IOException;
import java.io.PrintStream;

/** Class designed to output elements to a file */
public class PrintToFile implements PrintMatrix {
    private int i;

    /**
     * Displays the elements of the matrix in the file
     * @param matrix matrix of elements that need to be rewritten
     * @throws IOException exception required to check file for openness
     */
    public void print(int[][] matrix) throws IOException {
        PrintStream printStream = new PrintStream("text.txt");
        BuildSpiral.walkAroundTheMatrix(matrix, printStream);
    }
}
