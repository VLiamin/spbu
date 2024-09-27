package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {


    @Test
    void find() {
        HashTable hashTable = new HashTable();
        hashTable.add("plane");
        assertEquals(true,  hashTable.find("plane"));
    }

    @Test
    void remove(){
        HashTable hashTable = new HashTable();
        hashTable.add("apple");
        hashTable.remove("apple");
        assertEquals(false,  hashTable.find("apple"));
    }

    @Test
    void chooseHash(){
        HashTable hashTable = new HashTable();
        hashTable.add("accepted");
        HashFunction hash = new HashEffective();
        hashTable.chooseHash(hash);
        assertEquals(true,  hashTable.find("accepted"));
        assertEquals(false,  hashTable.find("notAccepted"));
    }
}