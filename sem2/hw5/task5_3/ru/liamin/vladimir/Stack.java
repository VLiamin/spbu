package ru.liamin.vladimir;

/** Implements the stack through pointers */
public class Stack {
    private int size;
    private StackElement top;

    /**
     * Add element to Stack
     * @param value value of new element
     */
    public void push(double value) {
        size++;
        top = new StackElement(value, top);
    }

    /**
     * Fetching element from stack
     * @return value of element
     */
    public double pop() {
        size--;
        if (top != null) {
            double value = top.symbol;
            top = top.next;
            return value;
        }
        System.out.println("Not found");
        return 0;
    }

    /** Clear stack */
    public void clear() {
        top = null;
        size = 0;
    }

    private class StackElement {
        private double symbol;
        private StackElement next;

        public StackElement(double value, StackElement top) {
            symbol = value;
            next = top;
        }
    }
}