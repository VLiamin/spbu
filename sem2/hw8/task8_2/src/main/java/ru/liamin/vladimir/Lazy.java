package ru.liamin.vladimir;

/**
 * Interface representing lazy evaluation
 * @param <T> type of the element
 */
public interface Lazy<T> {
    T get();
}