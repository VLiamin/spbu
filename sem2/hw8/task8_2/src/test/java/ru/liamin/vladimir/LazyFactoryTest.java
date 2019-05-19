package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LazyFactoryTest {

    @Test
    void createSimpleLazy() {

        Lazy<Integer> lazy = new LazyFactory().createSimpleLazy(() -> 341);
        assertEquals(341, lazy.get());
        assertEquals(341, lazy.get());
    }

    @Test
    void createSimpleLazyNull() {

        Lazy<Integer> lazy = new LazyFactory().createSimpleLazy(() -> null);
        assertEquals(null, lazy.get());
    }

    @Test
    void createMultithreadedLazyNull() {

        Lazy<Integer> lazy = new LazyFactory().createSimpleLazy(() -> null);
        assertEquals(null, lazy.get());
    }

    @Test
    void createMultithreadedLazy() {

        Lazy<Integer> lazy = new LazyFactory().createSimpleLazy(() -> 341);
        assertEquals(341, lazy.get());
        assertEquals(341, lazy.get());
    }

}