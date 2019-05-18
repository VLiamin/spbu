package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BuildSpiralTest {

    @Test
    void arrayTraversal() {

        ByteArrayOutputStream streamToCheck = new ByteArrayOutputStream();
        String elements = "2 1 2 3 4 3 2 1 0 ";
        System.setOut(new PrintStream(streamToCheck));
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = j + i;
            }
        }
        BuildSpiral.walkAroundTheMatrix(matrix, System.out);
        assertEquals(elements, streamToCheck.toString());
    }
}