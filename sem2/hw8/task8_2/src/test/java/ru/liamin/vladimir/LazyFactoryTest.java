package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


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

        Lazy<Integer> lazy = new LazyFactory().createMultithreadedLazy(() -> 341);
        assertEquals(341, lazy.get());
        assertEquals(341, lazy.get());
    }

    @Test
    public void presenceOfRacesTest() throws InterruptedException {
        ArrayList<Integer> numbers = new ArrayList<>();

        Lazy<Boolean> lazy = LazyFactory.createMultithreadedLazy(() -> {
            numbers.add(87);
            return true;
        });

        Runnable check = () -> {
            for (int i = 0; i < 10; i++) {
                lazy.get();
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(check));
            threads.get(i).start();
        }

        for (int i = 0; i < 10; i++) {
            threads.get(i).join();
        }

        assertEquals(1, numbers.size());
        assertEquals(87, (int) numbers.get(0));
    }
}