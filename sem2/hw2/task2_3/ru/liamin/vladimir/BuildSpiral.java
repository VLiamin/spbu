package ru.liamin.vladimir;

import java.io.PrintStream;

/** Loop traversal class */
public class BuildSpiral {

    /**
     * Method that writes elements from the matrix to the array
     * @param matrix source matrix of elements
     * @return array in which matrix elements are stored
     */
    public static void walkAroundTheMatrix(int[][] matrix, PrintStream printStream) {
        int column = Math.round(matrix.length / 2);
        int lines = column;
        int j = 0;
        int count = 0;

        printStream.print(matrix[lines][column] + " ");
        j++;
        while ((column != 0) && (lines != 0))
        {

            column--;
            printStream.print(matrix[lines][column] + " ");
            j++;
            for (int i = 0; i <= 0 + count * 2; i++)
            {
                lines++;
                printStream.print(matrix[lines][column] + " ");
                j++;
            }
            for (int i = 0; i <= 1 + count * 2; i++)
            {
                column++;
                printStream.print(matrix[lines][column] + " ");
                j++;
            }
            for (int i = 0; i <= 1 + count * 2; i++)
            {
                lines--;
                printStream.print(matrix[lines][column] + " ");
                j++;
            }
            for (int i = 0; i <= 1 + count * 2; i++)
            {
                column--;
                printStream.print(matrix[lines][column] + " ");
                j++;
            }
            count++;
        }
    }
}