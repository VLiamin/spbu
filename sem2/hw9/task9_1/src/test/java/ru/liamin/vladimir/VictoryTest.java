package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VictoryTest {

    @Test
    void winFalse() {

        String[][] elements = new String[3][3];
        for (int i = 0; i < 3; i++)
            elements[1][i] = "X";
        assertEquals("X", Victory.win(elements, true));
        for (int i = 0; i < 3; i++) {

            elements[i][2] = "0";
            if (i != 2)
                elements[1][i] = "";
        }
        assertEquals("0", Victory.win(elements, false));
        elements[0][2] = "";
        assertEquals("F", Victory.win(elements, true));
     }

    @Test
    void winTrue() {

        String[][] elements = new String[3][3];
        for (int i = 0; i < 3; i++)
            elements[2][i] = "X";
        assertEquals("X", Victory.win(elements, true));
    }

    @Test
    void checkForVictoryInTheBeginOfGame() {
        String[][] elements = new String[3][3];
        elements[0][0] = "X";
        elements[0][2] = "X";
        elements[1][1] = "X";
        elements[2][1] = "X";
        elements[0][1] = "0";
        elements[1][0] = "0";
        elements[1][2] = "0";
        elements[2][0] = "0";
        elements[2][2] = "0";
        assertEquals("D", Victory.win(elements, true));

    }
}