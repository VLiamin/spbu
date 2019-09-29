package ru.liamin.vladimir;

/** Hash implementation class with function f(x) = x mod m */
public class HashQuickly implements HashFunction {

    /**
     * Hash implementation method
     * @param word value of an element
     * @param size hash table size
     * @return hash of the element
     */
    public int countHash(String word, int size) {
        char[] symbols = word.toCharArray();
        int value = 0;
        for (Character symbol : symbols) {

            value = (value + symbol) % (size / 10);
        }

        return value;
    }
}
