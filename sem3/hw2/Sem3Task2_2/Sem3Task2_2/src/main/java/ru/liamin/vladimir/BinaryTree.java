package ru.liamin.vladimir;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Сlass implements a binary tree
 * @param <T> type of a tree elements
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node top;
    private ArrayList<T> deletedElements = new ArrayList<>();

    /**
     * Method of adding an item to the tree
     * @param value value of an element
     * @return true is element added
     */
    public boolean add(T value) {
        if (top == null) {
            top = new Node(value);
            return true;
        }
        Node temp = top;
        while (true) {
            if (value.compareTo((T) temp.value) > 0) {
                if (temp.right != null)
                    temp = temp.right;
                else {
                    temp.right = new Node(value);
                    return true;
                }
            } else if (value.compareTo((T) temp.value) < 0) {
                if (temp.left != null)
                    temp = temp.left;
                else {
                    temp.left = new Node(value);
                    return true;
                }
            } else
                return false;
        }
    }

    /**
     * Method which check tree on emptiness
     * @return true if tree is empty
     */
    public boolean isEmpty() {
        if (top == null)
            return true;
        return false;
    }

    /**
     * Method that checks the tree for the presence of an element
     * @param element element which we search
     * @return true if tree contain element
     */
    public boolean find(T element) {
        Node temp = top;
        while (true) {
            if (element == temp.value)
                return true;
            if (element.compareTo((T) temp.value) > 0) {
                if (temp.right == null)
                    return false;
                temp = temp.right;
            } else {
                if (temp.left == null)
                    return false;
                temp = temp.left;
            }
        }
    }

    /**
     * Method which delete element from the tree
     * @param value element which we delete
     * @return true if element deleted
     */
    public boolean remove(T value) {
        if (top == null)
            return false;
        return top.remove(value, top, null);
    }

    /**
     * Method which writes tree items to a string
     * @return string of tree's items
     */
    public String toString() {
        ArrayList<T> elements = new ArrayList<>();
        copyTree(elements, top);
        return elements.toString();
    }

    /**
     * Method which writes tree items to a array
     * @return array of tree's items
     */
    public ArrayList<T> toArray() {
        ArrayList<T> elements = new ArrayList<>();
        copyTree(elements, top);
        return elements;
    }

    /**
     * Method which return iterator
     * @return iterator
     */
    public Iterator getIterator() {
        TreeIterator treeIterator = new TreeIterator();
        return treeIterator;
    }

    private void copyTree(ArrayList<T> elements, Node node) {

        if (node == null)
            return;
        elements.add((T) node.value);
        copyTree(elements, node.left);
        copyTree(elements, node.right);
    }

    private class Node<T extends Comparable<T>> {
        private Node right;
        private Node left;
        private T value;

        private Node(T value) {
            this.value = value;
        }


        private boolean remove(T value, Node node, Node previous) {
            if (value == node.value) {
                Node temp = null;
                if (node.right == null) {
                    temp = node.left;
                } else {
                    Node ptr = node.right;
                    if (ptr.left == null) {
                        ptr.left = node.left;
                        temp = ptr;
                    } else {
                        Node pmin = ptr.left;
                        while (pmin.left != null) {
                            ptr = pmin;
                            pmin = pmin.left;
                        }
                        ptr.left = pmin.right;
                        pmin.left = node.left;
                        pmin.right = node.right;
                        temp = pmin;
                    }
                }
                if (previous != null) {
                    if ((previous.right != null) && (previous.right.value == node.value))
                        previous.right = temp;
                    else
                        previous.left = temp;
                } else
                    top = temp;
                return true;
            } else if (value.compareTo((T) node.value) < 0) {
                if (node.left == null)
                    return false;
                return remove(value, node.left, node);
            } else {
                if (node.right == null)
                    return false;
                return remove(value, node.right, node);
            }
        }
    }

    private class TreeIterator implements Iterator<T> {
        private ArrayList<T> elements = new ArrayList<>();
        private int numberOfElement = 0;

        private TreeIterator() {
            copyTree(elements, top);
        }

        /**
         * Method which check on elements
         * @return false if no more items
         */
        @Override
        public boolean hasNext() {
            checkDeletedItems();
            return !elements.isEmpty();
        }

        /**
         * Method which return next element
         * @return next element
         */
        @Override
        public T next() {
            checkDeletedItems();
            if (elements.isEmpty())
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            return elements.remove(0);
        }

        /** Method which remove next element */
        @Override
        public void remove() {
            checkDeletedItems();
            if (!elements.isEmpty()) {
                if (BinaryTree.this.remove(elements.get(0))) {
                    deletedElements.add(elements.get(0));
                    elements.remove(0);
                }
            }
        }

        private void checkDeletedItems() {

            for (int i = numberOfElement; i < deletedElements.size(); i++) {
                if (elements.contains(deletedElements.get(i)))
                    elements.remove(i);
            }
            numberOfElement = deletedElements.size() - 1;
            if (numberOfElement < 0)
                numberOfElement = 0;
        }
    }
}
