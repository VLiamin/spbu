package ru.liamin.vladimir;

/** Interface that computes the hash value */
public interface HashFunction {

    /**
     * Method that computes the hash
     * @param number element whose hash will be computed
     * @return hash of the element
     */
    int countHash(int number);
}
