package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10, 2);
        queue.enqueue(8, 0);
        queue.enqueue(12, 4);
        queue.enqueue(15, 6);
        queue.enqueue(4, 5);
        assertEquals(15, queue.dequeue());
    }

    @Test
    void dequeue() {
        Queue<Integer> queue = new Queue<>();
        try {
            int value = queue.dequeue();
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), is("The queue is empty"));
        }
    }

    @Test
    void deque() {
        Queue<Integer> queue = new Queue<>();
        try {
            queue.deque();
        } catch (NullPointerException e) {
            assertThat(e.getMessage(), is("The queue is empty"));
        }
    }
}