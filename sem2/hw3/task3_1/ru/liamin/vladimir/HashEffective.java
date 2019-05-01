package ru.liamin.vladimir;

/** Hash implementation class with function f(x) = x + c mod m */
public class HashEffective implements HashFunction {

    /**
     * Hash implementation method
     * @param number value of an element
     * @return hash of the element
     */
    public int countHash(int number) {
        return (number + 52) % 100;
    }
}
