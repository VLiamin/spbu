package ru.liamin.vladimir;

/** Duplicate checking class */
public class ElementAlreadyExistsExeption extends Exception{
    /**
     * Duplicate checking method
     * @param message error message
     */
    public ElementAlreadyExistsExeption(String message){
        super(message);
    }
}
