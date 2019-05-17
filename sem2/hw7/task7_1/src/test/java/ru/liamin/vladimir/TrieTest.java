package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void push() {

        Trie trie = new Trie();
        trie.add("ava");
        trie.add("kesha");
        trie.add("ava");
        assertEquals(2, trie.size());
    }

    @Test
    void contains() {

        Trie trie = new Trie();
        trie.add("ava");
        trie.add("kesha");
        trie.add("ava");
        assertEquals(true, trie.contains("ava"));
        assertEquals(false, trie.contains("misha"));

    }

    @Test
    void howManyStartWithPrefix() {

        Trie trie = new Trie();
        trie.add("ava");
        trie.add("kesha");
        assertEquals(1, trie.howManyStartWithPrefix("a"));
        trie.add("asha");
        assertEquals(2, trie.howManyStartWithPrefix("a"));
    }

    @Test
    void remove() {

        Trie trie = new Trie();
        trie.add("ava");
        trie.add("kesha");
        trie.add("apple");
        trie.remove("kesha");
        assertEquals(2, trie.size());
        assertEquals(false, trie.contains("kesha"));
        assertEquals(false, trie.remove("ion"));
    }

    @Test
    public void serializeAndDeserializeTest() throws IOException, ClassNotFoundException {
        Trie trie = new Trie();

        trie.add("ava");
        trie.add("kesha");
        trie.add("apple");

        File file = new File("text.txt");
        trie.serialize(new FileOutputStream(file));

        trie.deserialize(new FileInputStream(file));

        assertEquals(3, trie.size());
        assertEquals(true, trie.contains("apple"));
    }
}