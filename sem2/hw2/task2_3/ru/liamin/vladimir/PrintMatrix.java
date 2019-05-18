package ru.liamin.vladimir;

import java.io.IOException;

/** Matrix output interface */
public interface PrintMatrix {
    /**
     * Matrix derivation method
     * @param matrix matrix of elements that need to be rewritten
     */
    void print(int[][] matrix) throws IOException;

}
