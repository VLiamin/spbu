package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

class TreeTest {

    @Test
    void count() {
        Tree tree = new Tree();
        char[] ArrayExpression = {'(', '+', ' ', '2', ' ', '2', ')'};
        tree.push(ArrayExpression);
        assertEquals(4, tree.count());
    }

    @Test
    void testArithmeticException() {
        Tree tree = new Tree();
        char[] ArrayExpression = {'(', '/', '3', ' ', '0', ')'};
        tree.push(ArrayExpression);
        try {
            tree.count();
            fail("Expected an ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), is("Division by zero"));
        }
    }

}

