package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashQuicklyTest {

    @Test
    void countHash() {
        HashFunction hach = new HashQuickly();
        assertEquals(28, hach.countHash("plane", 1000));
    }
}