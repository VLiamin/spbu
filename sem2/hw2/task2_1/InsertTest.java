package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertTest {

    @Test
    void run() {
        Insert insert = new Insert();
        int[] arrayOfNumbers = {2, 5, 1, 3, 7};
        int[] sortedArrayOfNumbers = {2, 5, 5, 7, 7};
        assertArrayEquals(sortedArrayOfNumbers, insert.run(arrayOfNumbers));
    }
}