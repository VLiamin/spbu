package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BuildSpiralTest {

    @Test
    void print() throws IOException {

        String elements = "2 1 2 3 4 3 2 1 0 ";
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = j + i;
            }
        }
        String file = "text.txt";
        PrintStream printStream = null;
        PrintMatrix printMatrix = new PrintToFile();
        printMatrix.print(matrix, printStream);

        FileReader in = new FileReader(file);
        Scanner scanner = new Scanner(in);

        assertEquals(elements, scanner.nextLine());
    }
}