package ru.liamin.vladimir;

import java.io.IOException;
import java.io.PrintStream;

/** Matrix output interface */
public interface PrintMatrix {

    /**
     * Method which print elements of matrix by spiral
     * @param matrix matrix which elements we print
     * @param printStream stream
     * @throws IOException
     */
    void print(int[][] matrix, PrintStream printStream) throws IOException;
}
