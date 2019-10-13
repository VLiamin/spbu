package ru.liamin.vladimir;

public class BinaryTree<T extends Comparable<T>> {
    private Node top;

    private class Node<T extends Comparable<T>> {
        private Node right;
        private Node left;
        private T value;
    }
}
