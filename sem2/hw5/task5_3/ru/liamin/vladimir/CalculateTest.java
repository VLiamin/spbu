package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

    @Test
    void countExpression() {
        List list = new List();
        Calculate calculate = new Calculate();
        list.push(3, 'b', 1);
        list.push(0, '*', 2);
        list.push(7, 'b', 3);
        list.sortList();
        assertEquals(calculate.countExpression(list), 21);
    }
}