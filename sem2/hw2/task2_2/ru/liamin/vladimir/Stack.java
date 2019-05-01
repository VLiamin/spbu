package ru.liamin.vladimir;

/** Interface implements the stack */
public interface Stack {
    /**
     * Method adding element to the stack
     * @param value element which will be added to the stack
     */
    void push(char value);

    /**
     * Method removing element from the stack
     * @return element which will be removed from the stack
     */
    char pop();

    /**
     * Method checking stack for emptiness
     * @return true if stack is empty
     */
    boolean isEmpty();

    /**
     * Method which counting elements in the stack
     * @return number of the elements
     */
    int count();

    /** Method which printing elements of stack */
    void printStack();

    /**
     * Method which checking for minus or plus
     * @return if '-' or '+' return true
     */
    boolean isPlusOrMinus();

    /** Method which clear stack */
    void clear();

}
