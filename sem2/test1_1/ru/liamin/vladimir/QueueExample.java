package ru.liamin.vladimir;

import java.io.IOException;

/** Class showing the implementation of the queue */
public class QueueExample {

    /**
     * Method showing the implementation of the queue
     * @param args args array of arguments
     * @throws IOException exception reporting empty queue
     */
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10, 2);
        queue.enqueue(12, 3);
        queue.enqueue(14, 5);
        queue.enqueue(8, 1);
        int value = 0;
        try {
            value = queue.dequeue();
            System.out.println(value);
        } catch (NullPointerException e) {
            System.out.println("\nThe queue is empty.");
        }

        try {
            queue.deque();
        } catch (NullPointerException e) {
            System.out.println("\nThe queue is empty.");
        }
    }
}
