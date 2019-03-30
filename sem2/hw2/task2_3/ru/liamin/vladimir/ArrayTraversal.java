package ru.liamin.vladimir;

/** Loop traversal class */
public class ArrayTraversal {
    private int column;
    private int lines;
    private int j;
    private int count;

    /**
     * Method that writes elements from the matrix to the array
     * @param matrix source matrix of elements
     * @return array in which matrix elements are stored
     */
    public int[] ArrayTraversal(int[][] matrix) {
        int[] elements = new int[matrix.length * matrix.length];
        column = Math.round(matrix.length / 2);
        lines = column;
        j = 0;
        elements[j] = matrix[lines][column];
        j++;
        while ((column != 0) && (lines != 0))
        {

            column--;
            elements[j] = matrix[lines][column];
            j++;
            for (int i = 0; i <= 0 + count * 2; i++)
            {
                lines++;
                elements[j] = matrix[lines][column];
                j++;
            }
            for (int i = 0; i <= 1 + count * 2; i++)
            {
                column++;
                elements[j] = matrix[lines][column];
                j++;
            }
            for (int i = 0; i <= 1 + count * 2; i++)
            {
                lines--;
                elements[j] = matrix[lines][column];
                j++;
            }
            for (int i = 0; i <= 1 + count * 2; i++)
            {
                column--;
                elements[j] = matrix[lines][column];
                j++;
            }
            count++;
        }
        return elements;
    }
}