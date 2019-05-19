package ru.liamin.vladimir;

/**
 * Interface representing lazy evaluation
 * @param <T> type of the element
 */
public interface Lazy<T> {
    /**
     * Method that calculates the value
     * @return value that was calculated
     */
    T get();
}