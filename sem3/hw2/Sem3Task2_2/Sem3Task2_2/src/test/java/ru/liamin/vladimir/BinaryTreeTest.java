package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    /*
     *  6
     * / \
     * 3  15
     *    /
     *   7
     *   \
     *    9
     */
    @Test
    void getIterator1() {

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(6);
        binaryTree.add(15);
        binaryTree.add(7);
        binaryTree.add(3);
        binaryTree.add(9);
        Iterator iterator1 = binaryTree.getIterator();
        Iterator iterator2 = binaryTree.getIterator();
        iterator1.next();
        iterator1.next();
        iterator2.next();
        iterator2.next();
        iterator2.remove();
        assertEquals(7, iterator1.next());
    }

    @Test
    void getIterator2() {

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(6);
        binaryTree.add(15);
        binaryTree.add(7);
        binaryTree.add(3);
        binaryTree.add(9);
        Iterator iterator1 = binaryTree.getIterator();
        Iterator iterator2 = binaryTree.getIterator();
        iterator1.next();
        iterator2.next();
        iterator1.remove();
        assertEquals(15, iterator2.next());
        assertEquals(7, iterator2.next());
    }

    @Test
    void add() {

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(6);
        binaryTree.add(15);
        binaryTree.add(7);
        binaryTree.add(3);
        binaryTree.add(9);
        int[] elements = new int[5];
        int i = 0;
        for (Integer x : binaryTree.toArray()) {
            elements[i] = x;
            i++;
        }
        int[] array = {6, 3, 15, 7, 9};
        assertArrayEquals(array, elements);
    }

    @Test
    void find() {

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(6);
        binaryTree.add(15);
        binaryTree.add(7);
        binaryTree.add(3);
        binaryTree.add(9);
        assertEquals(true, binaryTree.find(7));
        binaryTree.remove(7);
        assertEquals(false, binaryTree.find(7));
    }
}