package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertTest {

    @Test
    void run() {
        Insert insert = new Insert();
        int[] arrayOfNumbers = {2, 5, 1, 3, 7};
        int[] sortedArrayOfNumbers = {1, 2, 3, 5, 7};
        insert.run(arrayOfNumbers);
        assertArrayEquals(sortedArrayOfNumbers, arrayOfNumbers);
    }
}