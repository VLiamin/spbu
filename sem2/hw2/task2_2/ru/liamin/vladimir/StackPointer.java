package ru.liamin.vladimir;

/** Implements the stack through pointers */
public class StackPointer implements Stack {
    private int size;
    private StackElement top;

    /**
     * Add element to Stack
     * @param value value of new element
     */
    public void push(char value) {
        size++;
        top = new StackElement(value, top);
    }

    /**
     * Fetching element from stack
     * @return value of element
     */
    public char pop() {
        size--;
        if (top != null) {
            char value = top.symbol;
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
            System.out.println(current.symbol);
            current = current.next;
        }
    }

    /**
     * Shows the sign of the operation in the first place of the stack
     * @return return true if the addition or subtraction sign is in the first place of the stack
     */
    public boolean isPlusOrMinus(){
        if (top == null) return false;
        if ((top.symbol == '+') || (top.symbol == '-'))
            return true;
        return false;
    }

    /** Clear stack */
    public void clear() {
        top = null;
        size = 0;
    }

    private class StackElement {
        private char symbol;
        private StackElement next;

        public StackElement(char value, StackElement top) {
            symbol = value;
            next = top;
        }
    }
}
