package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {


    @Test
    void find() {
        HashTable hashTable = new HashTable();
        hashTable.push(10, 1);
        assertEquals(true,  hashTable.find(10, 1));
    }
    @Test
    void pop(){
        HashTable hashTable = new HashTable();
        hashTable.push(10, 1);
        hashTable.pop(10, 1);
        assertEquals(false,  hashTable.find(10, 1));
    }
}