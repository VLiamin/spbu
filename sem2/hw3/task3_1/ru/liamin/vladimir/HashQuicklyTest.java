package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashQuicklyTest {

    @Test
    void countHash() {
        Hash hach = new HashQuickly();
        int number = 20;
        assertEquals(20, hach.countHash(number));
    }
}