package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VictoryTest {

    @Test
    void checkForVictoryInTheMiddleOfGame() {

        Victory victory = new Victory();
        int[] numbers = {1, -1, 1, 1, -1, -1, 1, 0 ,0};
        assertEquals(true, victory.checkForVictory(numbers, 3, 1));
        assertEquals(false, victory.checkForVictory(numbers, 1, 3));
        assertEquals(false, victory.checkForVictory(numbers, 4, 0));
        assertEquals(false, victory.checkForVictory(numbers, 2, 0));
    }

    @Test
    void checkForVictoryInTheEndOfGame() {

        Victory victory = new Victory();
        int[] numbers = {1, -1, -1, -1, 1, -1, 1, 1, 1};
        assertEquals(false, victory.checkForVictory(numbers, 3, 1));
        assertEquals(true, victory.checkForVictory(numbers, 1, 3));
        assertEquals(true, victory.checkForVictory(numbers, 4, 0));
        assertEquals(false, victory.checkForVictory(numbers, 2, 0));
    }

    @Test
    void checkForVictoryInTheBeginOfGame() {

        Victory victory = new Victory();
        int[] numbers = {1, -1, -1, 0, 0, 0, 0, 0, 0};
        assertEquals(false, victory.checkForVictory(numbers, 3, 1));
        assertEquals(false, victory.checkForVictory(numbers, 1, 3));
        assertEquals(false, victory.checkForVictory(numbers, 4, 0));
        assertEquals(false, victory.checkForVictory(numbers, 2, 0));
    }
}