package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {


    @Test
    void find() {
        HashTable hashTable = new HashTable();
        hashTable.add(10);
        assertEquals(true,  hashTable.find(10));
    }
    @Test
    void remove(){
        HashTable hashTable = new HashTable();
        hashTable.add(10);
        hashTable.remove(10);
        assertEquals(false,  hashTable.find(10));
    }
}