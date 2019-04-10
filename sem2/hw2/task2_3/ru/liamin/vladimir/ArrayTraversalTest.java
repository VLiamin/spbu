package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTraversalTest {

    @Test
    void arrayTraversal() {
        ArrayTraversal arrayTraversal = new ArrayTraversal();
        int[] elements = {2, 1, 2, 3, 4, 3, 2, 1, 0};
        int[] matrixElements = new int[9];
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                matrix[i][j] = i + j;
            }
        }
        arrayTraversal.arrayTraversal(matrix, matrixElements);
        assertArrayEquals(elements, matrixElements);
    }
}