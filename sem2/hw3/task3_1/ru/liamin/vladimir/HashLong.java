package ru.liamin.vladimir;

/** Hash implementation class */
public class HashLong implements Hash{

    /**
     * Hash implementation method
     * @param number value of an element
     * @return hash of the element
     */
    public int countHash(int number){
        return (number + 52) % 100;
    }
}
