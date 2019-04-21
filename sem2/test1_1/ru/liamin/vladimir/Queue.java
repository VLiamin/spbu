package ru.liamin.vladimir;

/**
 * Class implements queue
 * @param <T> generic type
 */
public class Queue<T> {
    private int size;
    private ListElement head;

    /**
     * Method adds an element to the queue
     * @param value    value of an element
     * @param priority priority of an element
     */
    public void enqueue(T value, int priority) {
        size++;
        if (size == 1) {
            head = new ListElement(value, head, priority);
            return;
        }

        ListElement temp = head;

        if (priority > head.priority) {
            temp = new ListElement(value, head, priority);
            head = temp;
            return;
        }

        while ((temp.next != null) && (priority < temp.next.priority))
            temp = temp.next;

        temp.next = new ListElement(value, temp.next, priority);
        return;
    }

    /**
     * Method removes an element to the queue
     * @return value of an element
     * @throws NullPointerException exception reporting empty queue
     */
    public T dequeue() throws NullPointerException {
        if (head == null)
            throw new NullPointerException("The queue is empty");
        T value = head.value;
        head = head.next;
        return value;
    }

    /**
     * Method checks the queue to empty
     * @throws NullPointerException exception reporting empty queue
     */
    public void deque() throws NullPointerException {
        if (head == null)
            throw new NullPointerException("The queue is empty");
    }

    private class ListElement {
        private T value;
        private int priority;
        private ListElement next;

        public ListElement(T value, ListElement next, int priority) {
            this.value = value;
            this.next = next;
            this.priority = priority;
        }
    }
}
