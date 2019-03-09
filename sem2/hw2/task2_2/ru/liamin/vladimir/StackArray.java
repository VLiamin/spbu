package ru.liamin.vladimir;

/** Implements the stack through array */
public class StackArray implements Stack {
    private int size;
    private char stackArray[];
    private int top;

    public StackArray(int length){
        stackArray = new char[length];
        top = -1;
    }

    /**
     * Add element to Stack
     * @param value value of new element
     */
    public void push(char value){
        stackArray[++top] = value;
        size++;
    }

    /**
     * Fetching element from stack
     * @return value of element
     */
    public char pop(){
        size--;
        return stackArray[top--];
    }

    /**
     * Check for emptiness
     * @return return true if stack is empty
     */
    public boolean isEmpty(){
        if (top == -1)
            return true;
        return false;
    }

    /**
     * Count of elements in stack
     * @return number of elements in stack
     */
    public int count(){
        return size;
    }

    /** Print stack elements */
    public void printStack(){
        int current = top;
        while (current != -1){
            System.out.print(" " + stackArray[current]);
            current--;
        }
    }

    /**
     * Shows the sign of the operation in the first place of the stack
     * @return return true if the addition or subtraction sign is in the first place of the stack
     */
    public boolean isPlusOrMinus() {
        if (top == -1) return false;
        if ((stackArray[top] == '-') || (stackArray[top] == '+')) return true;
        return false;
    }

    /** Clear stack */
    public void clear(){
        top = -1;
    }
}
