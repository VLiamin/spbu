package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {
    @Test
    void countExpression() {
        Stack stack;
        stack = new StackPointer();
        Calculate calculate = new Calculate(stack);
        char[] expression = {'5', '+', '1', '*', '7'};
        assertEquals(12, calculate.countExpression(expression));
    }
}