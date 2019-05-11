package ru.liamin.vladimir;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/** Implementation of the trie class */
public class Trie implements Serializable {

    private Node head = new Node();
    private int size;
    private ArrayList<String> elements = new ArrayList<>();

    /**
     * Method adds a string to the trie
     * @param element element that is added to trie
     * @return true if element added
     */
    public boolean add(String element) {

        if (contains(element))
            return false;

        Node current = head;
        for (int i = 0; i < element.length(); i++) {

            current.numberStartWithPrefix++;
            char symbol = element.charAt(i);
            Node temp = current.children.get(symbol);
            if (temp == null) {
                temp = new Node();
                current.children.put(symbol, temp);
            }

            current = temp;
        }

        size++;
        current.isEnd = true;
        current.numberStartWithPrefix++;

        return true;
    }

    /**
     * Method that checks if an element is contained in a trie
     * @param element the item we are checking
     * @return true if element contained
     */
    public boolean contains(String element) {

        Node current = head;
        for (int i = 0; i < element.length(); i++) {

            if (current == null)
                return false;
            char symbol = element.charAt(i);
            current = current.children.get(symbol);
        }

        return current.isEnd;
    }

    /**
     * Method that returns trie's size
     * @return trie's size
     */
    public int size() {
        return size;
    }

    /**
     * Method that returns how many strings starts with a given prefix
     * @param prefix beginning of string
     * @return the number of strings that starts with this prefix
     */
    public int howManyStartWithPrefix(String prefix) {

        Node current = head;
        for (int i = 0; i < prefix.length(); i++) {

            char symbol = prefix.charAt(i);
            current = current.children.get(symbol);
            if (current == null)
                return 0;
        }

        return current.numberStartWithPrefix;
    }

    /**
     * Method that removes elements from trie
     * @param element item to be removed
     * @return true if element removed
     */
    public boolean remove(String element) {
        Node current = head;
        Node temp = null;
        if (!contains(element))
            return false;

        for (int i = 0; i < element.length(); i++) {

            char symbol = element.charAt(i);
            temp = current;
            current = current.children.get(symbol);
            current.numberStartWithPrefix--;
            if (i == element.length() - 1) {

                size--;
                current.isEnd = false;
            }

            if (current.numberStartWithPrefix == 0) {

                size--;
                temp.children.remove(symbol);
                break;
            }
        }
        return true;
    }

    /**
     * Method that writes the trie to the out stream
     * @param out the stream that is filled with data from the tree
     * @throws IOException non-serialization exception
     */
    public void serialize(OutputStream out) throws IOException {
        BufferedWriter outputFile = new BufferedWriter(new OutputStreamWriter(out));

        for (String word: elements) {
            outputFile.write(word);
            outputFile.write("\n");
        }

        outputFile.close();
        out.close();

    }

    /**
     * Method that replaces the old trie data from the stream
     * @param in input stream
     * @throws IOException non-deserialization exception
     * @throws ClassNotFoundException exception if class Trie is not found
     */
    public void deserialize(InputStream in) throws IOException, ClassNotFoundException {

        BufferedReader inputFile = new BufferedReader(new InputStreamReader(in));

        while (inputFile.ready()) {
            this.add(inputFile.readLine());
        }

        inputFile.close();
        in.close();
    }

    /** Class describing the element of trie */
    private class Node implements Serializable {
        private int numberStartWithPrefix;
        private HashMap<Character, Node> children;
        private boolean isEnd = false;

        private Node() {

            children = new HashMap<>();
        }
    }
}
