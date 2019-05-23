package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {

    @Test
    void pop() {
        Stack stack = new StackArray(100);
        stack.push('1');
        assertEquals('1', stack.pop());
    }

    @Test
    void isEmpty() {
        Stack stack = new StackArray(100);
        assertEquals(true, stack.isEmpty());
    }
}