package ru.liamin.vladimir;

import java.util.function.Supplier;

/**
 * Class with a simple version with a guarantee of correct operation in single-threaded mode
 * @param <T> type of the element
 */
public class SimpleLazy<T> implements Lazy {

    private Supplier<T> supplier;
    private T value;

    /**
     * Constructor who accepts Supplier
     * @param supplier supplier from which the value is calculated
     */
    public SimpleLazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * Method that calculates the value
     * @return value that was calculated
     */
    public T get() {

        if (value != null)
            return value;

        if (supplier != null)
            value = supplier.get();
        else
            value = null;
        return value;
    }
}
