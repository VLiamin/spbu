package ru.liamin.vladimir;

/** Method showing the implementation of the collection */
public class AVLTreeExample {
    /**
     * Method showing the implementation of the collection
     * @param args array of arguments
     */
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        System.out.println(avlTree.isEmpty());
        System.out.println(avlTree.add(10));
        System.out.println(avlTree.add(10));
        avlTree.add(20);
        System.out.println(avlTree.isEmpty());
        avlTree.add(30);
        avlTree.add(40);
        System.out.println(avlTree.size());
        System.out.println(avlTree.remove(20));
        System.out.println(avlTree.remove(20));
        System.out.println(avlTree.size());
        System.out.println(avlTree.contains(16));
        System.out.println(avlTree.contains(30));
    }
}
