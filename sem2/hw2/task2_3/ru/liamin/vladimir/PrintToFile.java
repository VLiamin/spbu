package ru.liamin.vladimir;

import java.io.FileWriter;
import java.io.IOException;

/** Class designed to output elements to a file */
public class PrintToFile implements Array {
    private int i;

    /**
     * Displays the elements of the matrix in the file
     * @param elements elements in the matrix when traversing it through the cycle
     * @throws IOException exception required to check file for openness
     */
    public void print(int[] elements) throws IOException {
        FileWriter file = new FileWriter("text.txt");
        for (i = 0; i < elements.length; i++) {
            file.write(elements[i] + " ");
        }
        file.close();
    }
}
