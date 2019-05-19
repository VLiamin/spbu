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
        return new Lazy<T>() {

            private boolean isCalculate = false;
            private T value;

            @Override
            public T get() {
                if (isCalculate == true)
                    return value;

                if (supplier != null)
                    value = supplier.get();
                else
                    value = null;
                isCalculate = true;
                return value;
            }
        };
    }

    /**
     * Method with guaranteed correct operation in multithreaded mode
     * @param supplier library class Supplier
     * @param <T> type of the element
     * @return value of the element
     */
    public static <T> Lazy<T> createMultithreadedLazy(Supplier<T> supplier) {
        return new Lazy<T>() {
            private volatile boolean isCalculate = false;
            private volatile T value;

            @Override
            public T get() {
                synchronized (this) {
                    if (supplier != null)
                        value = supplier.get();
                    else
                        value = null;
                    isCalculate = true;
                }

                return value;
            }
        };
    }
}
