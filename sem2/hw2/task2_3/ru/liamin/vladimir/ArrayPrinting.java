package ru.liamin.vladimir;

import java.io.IOException;

/** Matrix output interface */
public interface ArrayPrinting {
    /**
     * Matrix derivation method
     * @param elements array of matrix elements
     */
    void print(int[] elements) throws IOException;

}
