package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void contains() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        System.out.println(avlTree.add(10));
        assertEquals(avlTree.contains(10), true);
    }

    @Test
    void iterator() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(10);
        avlTree.add(12);
        avlTree.add(11);
        Iterator<Integer> treeIterator = avlTree.iterator();
        assertEquals(treeIterator.hasNext(), true);
    }

    @Test
    void toArray() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Integer[] elements = {11, 10, 12};
        avlTree.add(10);
        avlTree.add(12);
        avlTree.add(11);

        assertArrayEquals(elements, avlTree.toArray());
    }

    @Test
    void containsAllFalse() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(10);
        avlTree.add(12);
        avlTree.add(11);
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        assertEquals(avlTree.containsAll(collection), false);
    }

    @Test
    void containsAllTrue() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Collection<Integer> collection = new ArrayList<>();
        avlTree.add(10);
        avlTree.add(12);
        avlTree.add(11);
        collection.add(12);
        collection.add(11);
        collection.add(10);
        assertEquals(avlTree.containsAll(collection), true);
    }

    @Test
    void removeAllTrue() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Collection<Integer> collection = new ArrayList<>();
        avlTree.add(12);
        avlTree.add(13);
        avlTree.add(17);
        collection.add(12);
        collection.add(13);
        assertEquals(avlTree.removeAll(collection), true);
    }

    @Test
    void removeAllFalse() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Collection<Integer> collection = new ArrayList<>();
        avlTree.add(12);
        avlTree.add(13);
        avlTree.add(17);
        collection.add(12);
        collection.add(14);
        assertEquals(avlTree.removeAll(collection), false);
    }

    @Test
    void retainAll() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        Collection<Integer> collection = new ArrayList<>();
        avlTree.add(12);
        avlTree.add(13);
        avlTree.add(17);
        collection.add(12);
        collection.add(14);
        assertEquals(avlTree.retainAll(collection), true);
    }
}