package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VictoryTest {

    @Test
    void win() {

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
}