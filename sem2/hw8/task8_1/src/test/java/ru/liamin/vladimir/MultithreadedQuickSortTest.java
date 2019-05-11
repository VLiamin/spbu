package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultithreadedQuickSortTest {

    private static MultithreadedQuickSort multithreadedQuickSort = new MultithreadedQuickSort();

    @Test
    void sort() {

        int[] numners = {1, 2, 3, 2, 4, 4};
        int[] copyNumbers = {1, 2, 2, 3, 4, 4};

        multithreadedQuickSort.sort(numners);
        assertArrayEquals(numners, copyNumbers);
    }
}