package ru.liamin.vladimir;

/** Implementation of a stack on a single-linked list */
public class Stack {
    private int size;
    private StackElement top;

    private class StackElement {
        private int number;
        private StackElement next;

        private StackElement(int value, StackElement top) {
            number = value;
            next = top;
        }
    }

    /**
     * Add element to Stack
     * @param value value of new element
     */
    public void push(int value) {
        size++;
        top = new StackElement(value, top);
    }

    /**
     * Fetching element from stack
     * @return value of element
     */
    public int pop() {
        size--;
        if (top != null) {
            int value = top.number;
            top = top.next;
            return value;
        }
        System.out.println("Not found");
        return 0;
    }

    /**
     * Check for emptiness
     * @return return true if stack is empty
     */
    public boolean isEmpty() {
        return (top == null);
    }

    /**
     * Count of elements in stack
     * @return number of elements in stack
     */
    public int count() {
        return size;
    }

    /** Print stack elements */
    public void printStack() {
        System.out.println("Elements of stack: ");
        StackElement current = top;
        while (current != null) {
            System.out.println(current.number);
            current = current.next;
        }
    }

    /** Clear stack */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * Demonstrates ru.liamin.vladimir.Stack methods
     * @param args array of arguments
     */
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        System.out.println("Size of stack: " + stack.count());
        stack.printStack();
        if (!stack.isEmpty())
            System.out.println("Pop value: " + stack.pop());
        System.out.println("Size of stack: " + stack.count());
        stack.printStack();
        stack.push(4);
        stack.push(9);
        System.out.println("Size of stack: " + stack.count());
        stack.printStack();
        stack.clear();
        System.out.println("Size of stack: " + stack.count());
        stack.printStack();
    }
}