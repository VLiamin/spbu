package ru.liamin.vladimir;

/** Class checking if an item is in the list */
public class ElementDoesNotExistExeption extends Exception {
    /**
     * Method checking if an item is in the list
     * @param message error message
     */
    public ElementDoesNotExistExeption(String message) {
        super(message);
    }
}
