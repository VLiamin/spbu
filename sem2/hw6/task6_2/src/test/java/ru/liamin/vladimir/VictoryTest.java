package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VictoryTest {

    @Test
    void checkForVictory() {

        Victory victory = new Victory();
        int[] numbers = {1, -1, 1, 1, -1, -1, 1, 0 ,0};
        assertEquals(true, victory.checkForVictory(numbers, 3, 1));
        assertEquals(false, victory.checkForVictory(numbers, 1, 3));
        assertEquals(false, victory.checkForVictory(numbers, 4, 0));
        assertEquals(false, victory.checkForVictory(numbers, 2, 0));
    }
}