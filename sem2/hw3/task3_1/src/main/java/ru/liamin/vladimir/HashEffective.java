package ru.liamin.vladimir;

/** Hash implementation class with function f(x) = x + c mod m */
public class HashEffective implements HashFunction {

    /**
     * Hash implementation method
     * @param word value of an element
     * @param size hash table size
     * @return hash of the element
     */
    public int countHash(String word, int size) {

        char[] symbols = word.toCharArray();
        int value = 0;
        for (int i = 0; i < symbols.length; i++) {

            value = (value + symbols[i] + 111) % (size / 10);
        }

        return value;
    }
}
