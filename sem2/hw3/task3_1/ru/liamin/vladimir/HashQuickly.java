package ru.liamin.vladimir;

/** Hash implementation class */
public class HashQuickly implements Hash{

    /**
     * Hash implementation method
     * @param number value of an element
     * @return hash of the element
     */
    public int countHash(int number){
        return number % 100;
    }
}
