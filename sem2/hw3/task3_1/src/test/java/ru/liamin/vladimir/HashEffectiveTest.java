package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashEffectiveTest {

    @Test
    void countHash() {
        HashFunction hach = new HashEffective();
        assertEquals(45, hach.countHash("ava", 1000));
    }
}