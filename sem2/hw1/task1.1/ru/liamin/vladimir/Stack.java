package ru.liamin.vladimir;

/** Implementation of a stack on a single-linked list */
public class Stack {
    private int size;
    private StackElement head;

    /**
     * Add element to Stack
     * @param value value of new element
     */
    public void push(int value) {
        size++;
        head = new StackElement(value, head);
    }

    /**
     * Fetching element from stack
     * @return value of element
     */
    public int pop() {
        if (size > 0)
            size--;
        if (head != null) {
            int value = head.number;
            head = head.next;
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
        return head == null;
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
        StackElement current = head;
        while (current != null) {
            System.out.println(current.number);
            current = current.next;
        }
    }

    /** Clear stack */
    public void clear() {
        head = null;
        size = 0;
    }

    private class StackElement {
        private int number;
        private StackElement next;

        private StackElement(int value, StackElement element) {
            number = value;
            next = element;
        }
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