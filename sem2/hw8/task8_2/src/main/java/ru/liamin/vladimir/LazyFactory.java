package ru.liamin.vladimir;

import java.util.function.Supplier;

/** Class that creates an object lazy */
public class LazyFactory {

    /**
     * Method with a simple version with a guarantee of correct operation in single-threaded mode
     * @param supplier library class Supplier
     * @param <T> type of the element
     * @return value of the element
     */
    public static <T> Lazy<T> createSimpleLazy(Supplier<T> supplier) {
        return new SimpleLazy<T>(supplier);
    }


    /**
     * Method with guaranteed correct operation in multithreaded mode
     * @param supplier library class Supplier
     * @param <T> type of the element
     * @return value of the element
     */
    public static <T> Lazy<T> createMultithreadedLazy(Supplier<T> supplier) {
        return new MultithreadedLazy<T>(supplier);
    }
}


