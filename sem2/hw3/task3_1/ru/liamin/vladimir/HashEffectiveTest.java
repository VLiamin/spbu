package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashEffectiveTest {

    @Test
    void countHash() {
        HashFunction hach = new HashEffective();
        int number = 20;
        assertEquals(72, hach.countHash(number));
    }
}