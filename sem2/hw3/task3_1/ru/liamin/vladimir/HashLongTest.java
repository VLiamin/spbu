package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashLongTest {

    @Test
    void countHash() {
        Hash hach = new HashLong();
        int number = 20;
        assertEquals(72, hach.countHash(number));
    }
}