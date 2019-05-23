package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackPointerTest {

    @Test
    void pop() {
        Stack stack = new StackPointer();
        stack.push('3');
        assertEquals('3', stack.pop());
    }

    @Test
    void isEmpty() {
        Stack stack = new StackPointer();
        stack.push('3');
        assertEquals(false, stack.isEmpty());
    }
}