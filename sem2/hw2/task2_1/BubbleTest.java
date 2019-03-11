package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleTest {

    @Test
    void run() {
        Bubble bubble = new Bubble();
        int[] arrayOfNumbers = {2, 4, 1, 3, 7};
        int[] sortedArrayOfNumbers = {7, 4, 3, 2, 1};
        bubble.run(arrayOfNumbers);
        assertArrayEquals(sortedArrayOfNumbers,arrayOfNumbers);
    }
}