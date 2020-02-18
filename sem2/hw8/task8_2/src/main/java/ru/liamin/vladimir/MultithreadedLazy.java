package ru.liamin.vladimir;

import java.util.function.Supplier;

/**
 * Class with guaranteed correct operation in multithreaded mode
 * @param <T> type of the element
 */
public class MultithreadedLazy<T> implements Lazy {

    private volatile Supplier<T> supplier;
    private volatile T value;

    /**
     * Constructor who accepts Supplier
     * @param supplier supplier from which the value is calculated
     */
    public MultithreadedLazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * Method that calculates the value
     * @return value that was calculated
     */
    @Override
    public T get() {
        if (value != null) {
            return value;
        }

        synchronized (this) {
            if (supplier != null)
                value = supplier.get();
            else
                value = null;
        }

        return value;
    }
}
