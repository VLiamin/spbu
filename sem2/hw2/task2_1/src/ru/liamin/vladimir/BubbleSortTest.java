package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleTest {

    @Test
    void run() {
        BubbleSort bubble = new BubbleSort();
        int[] arrayOfNumbers = {2, 4, 1, 3, 7};
        int[] sortedArrayOfNumbers = {7, 4, 3, 2, 1};
        bubble.sort(arrayOfNumbers);
        assertArrayEquals(sortedArrayOfNumbers,arrayOfNumbers);
    }
}