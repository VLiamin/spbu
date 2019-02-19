package ru.liamin.vladimir;

/* Implementation of a stack on a single-linked list
 */
public class Stack {
    private int size;
    public StackElement top;

    private class StackElement {
        protected int number;
        protected StackElement next;

        public StackElement(int value, StackElement top) {
            number = value;
            next = top;
        }
    }

    public Stack() {
        top = null;
        size = 0;
    }

    void push(int value) {
        size++;
        top = new StackElement(value, top);
    }

    public int pop() {
        size--;
        if (top != null) {
            int value = top.number;
            top = top.next;
            return value;
        } else {
            System.out.println("Not found");
            return 0;
        }
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int count() {
        return size;
    }

    public void printStack() {
        System.out.println("Elements of stack: ");
        StackElement current = top;
        while (current != null) {
            System.out.println(current.number);
            current = current.next;
        }
    }

    public void clear() {
        top = null;
        size = 0;
    }

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
