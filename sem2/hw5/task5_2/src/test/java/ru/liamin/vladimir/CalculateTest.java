package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @Test
    void count() {

        Calculate calculate = new Calculate();
        assertEquals("5.0", calculate.count(2, 3, "+"));
        assertEquals("6.0", calculate.count(2, 3, "*"));
        assertEquals("4.0", calculate.count(8, 2, "/"));
        assertEquals("5.0", calculate.count(8, 3, "-"));
    }

    @Test
    void arithmeticException() {

        Calculate calculate = new Calculate();
        assertThrows(ArithmeticException.class,
                () -> {
                    calculate.count(5, 0, "/");
                });
    }

}