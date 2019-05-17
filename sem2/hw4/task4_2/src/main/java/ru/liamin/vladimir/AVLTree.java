package ru.liamin.vladimir;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Class that implements the collection
 * @param <T> generic type
 */
public class AVLTree<T extends Comparable<T>> implements Collection<T> {
    private NodeElement head = new NodeElement();
    private int size;

    /**
     * Method showing the size of the collection and showing the structure
     * @return size of a collection
     */
    @Override
    public int size() {
        head.print();
        System.out.println();
        return size;
    }

    /**
     * Method showing collection is empty or not
     * @return true if collection is empty
     */
    @Override
    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    /**
     * Method showing if element contained in collection or not
     * @param o element which we are checking
     * @return true if element contained in collection
     */
    @Override
    public boolean contains(Object o) {
        return head.contains((T) o, false);
    }

    /**
     * Method returns an iterator over the elements in this collection.
     * @return iterator over the elements
     */
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator();
    }

    /**
     * Method returns an array containing all of the elements in this collection.
     * @return returns an array all of the elements
     */
    @Override
    public Object[] toArray() {
        ArrayList<T> elements = new ArrayList<>();
        head.printToArray(elements);

        return elements.toArray();
    }

    /**
     * Returns an array containing all of the elements in this collection
     * @param a the array into which the elements of this collection are to be stored
     * @param <T> generic type
     * @return returns an array all of the elements
     */
    @Override
    public <T> T[] toArray(T[] a) {
        ArrayList<T> elements = new ArrayList<>();
        for (Object element : this) {
            elements.add((T) element);
        }

        return elements.toArray(a);
    }

    /**
     * Method adding an element to the collection
     * @param value element which adding to the collection
     * @return true if element is added
     */
    @Override
    public boolean add(T value) {
        return head.add(value);
    }

    /**
     * Method delete an element to the collection
     * @param o element which will delete
     * @return true if element is deleted
     */
    @Override
    public boolean remove(Object o) {
        return head.remove((T) o, false);
    }

    /**
     * Method returns true if this collection contains all of the elements in the specified collection
     * @param c other collection
     * @return returns true if this collection contains all of the elements in the specified collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean isResult = true;
        for (Object element : c) {
            isResult = isResult && contains(element);
        }

        return isResult;
    }

    /**
     * Method adds all of the elements in the specified collection to this collection
     * @param c other collection
     * @return returns true if this collection contains all of the elements in the specified collection
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }

        return !c.isEmpty();
    }

    /**
     * Method removes all of this collection's elements that are also contained in the specified collection
     * @param c other collection
     * @return true if all elements are deleted
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isResult = true;
        for (Object element : c) {
            isResult = isResult && remove(element);
        }

        return isResult;
    }

    /**
     * Method retains only the elements in this collection that are contained in the specified collection
     * @param c other collection
     * @return true if element is deleted
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isResult = true;
        for (Object element : this) {
            if (!c.contains(element)) {
                remove(element);
                isResult = true;
            }
        }
        return isResult;
    }

    /** Method removes all of the elements from this collection */
    @Override
    public void clear() {
        head = null;
    }

    private class NodeElement {
        private Node root;

        private int height() {
            return root.height;
        }

        private int balanceFactor() {
            if ((root.right.root == null) && (root.left.root == null))
                return 0;
            if (root.right.root == null)
                return -root.left.height();
            if (root.left.root == null)
                return root.right.height();
            return root.right.height() - root.left.height();
        }

        private void fixHeight() {
            int hl = 0;
            if (root.left.root != null)
                hl = height();
            int hr = 0;
            if (root.right.root != null) {
                hr = root.right.height();
            }
            root.height = (hl > hr ? hl : hr) + 1;
        }
        private boolean add(T value) {
            if (root == null) {
                root = new Node(value);
                size++;
                return true;
            } else {
                if (root.value.equals(value)) {
                    return false;
                }
            }

            if (root.value.compareTo(value) > 0) {
                root.left.add(value);
            } else {
                root.right.add(value);
            }

            balance();
            return false;

        }


        private void balance() {
            fixHeight();
            if (balanceFactor() > 1) {
                if (root.right.balanceFactor() < 0)
                    root.right.rotateRight();
                rotateLeft();
                return;
            }
            if (balanceFactor() < -1) {
                if (root.left.balanceFactor() > 0)
                    root.left.rotateLeft();
                rotateRight();
                return;
            }
            return;
        }


        private void rotateLeft() {
            NodeElement temp = root.right;
            NodeElement newNode = new NodeElement();

            newNode.root = root;
            newNode.root.right = temp.root.left;
            temp.root.left = newNode;

            temp.fixHeight();
            newNode.fixHeight();

            root = temp.root;
        }

        private void rotateRight() {
            NodeElement temp = root.left;
            NodeElement newNode = new NodeElement();

            newNode.root = root;
            newNode.root.left = temp.root.right;
            temp.root.right = newNode;

            temp.fixHeight();
            newNode.fixHeight();

            root = temp.root;
        }

        private boolean contains(T value, boolean isElement) {
            if (root == null)
                return false;
            if (root.value.equals(value)) {
                return true;
            }
            if ((root.right != null) && (root.value.compareTo(value) < 0))
                isElement = root.right.contains(value, isElement);
            else if (root.right == null)
                return false;
            else if ((root.left != null) && (root.value.compareTo(value) > 0))
                isElement = root.left.contains(value, isElement);
            else
                return false;
            if (!isElement)
                return false;
            return true;
        }

        private boolean remove(T value, boolean isDelete) {

            if (root == null) {
                return false;
            }

            if (root.value.compareTo(value) > 0)
                isDelete = root.left.remove(value, isDelete);
            else if (root.value.compareTo(value) < 0)
                isDelete = root.right.remove(value, isDelete);

            if (value.equals(root.value)) {
                size--;
                NodeElement q = root.left;
                NodeElement r = root.right;
                root = null;
                if (r.root == null) {
                    root = q.root;
                    return true;
                }
                r.findMinimum();
                Node min = r.root;
                r.removeMinimum();
                min.right = r;
                min.left = q;
                root = min;
                balance();
                return true;
            }
            balance();
            return isDelete;
        }

        private void findMinimum() {
            if (root.left.root == null)
                return;
            root.left.findMinimum();
            return;
        }

        private void removeMinimum() {
            if (root.left.root == null) {
                root = root.right.root;
                return;
            }
            root.left.removeMinimum();
            balance();
            return;
        }

        private void print() {
            if (root == null) {
                System.out.print(" null ");
                return;
            }
            System.out.print("(");
            System.out.print(root.value + " ");
            if (root.left != null)
                root.left.print();
            if (root.right != null)
                root.right.print();
            System.out.print(")");
        }

        private void printToArray(ArrayList<T> elements) {

            if (root == null) {
                return;
            }
            elements.add(root.value);
            if (root.left != null)
                root.left.printToArray(elements);
            if (root.right != null)
                root.right.printToArray(elements);
        }
    }


    private class Node {
        private NodeElement right;
        private NodeElement left;
        private T value;
        private int height;

        private Node(T value) {
            right = new NodeElement();
            left = new NodeElement();
            this.value = value;
            height = 1;
        }
    }

    private class TreeIterator implements java.util.Iterator<T> {
        ArrayList<T> elements;

        private TreeIterator() {
            elements = new ArrayList<>();
            head.printToArray(elements);
        }

        @Override
        public boolean hasNext() {
            return !elements.isEmpty();
        }

        @Override
        public T next() {
            if (elements.isEmpty()) {
                return null;
            }

            return elements.remove(0);
        }
    }
}