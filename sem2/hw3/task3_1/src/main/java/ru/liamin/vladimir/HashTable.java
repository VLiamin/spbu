package ru.liamin.vladimir;

/** Implementation hash table */
public class HashTable {
    private HashFunction hash;
    private int size = 1000;
    private int currentSize;
    private int numberOfConflicts;
    private int maxLength;
    private List[] elements;

    public HashTable() {

        hash = new HashQuickly();
        elements = new List[size];
        for (int i = 0; i < size; i++)
            elements[i] = new List();
    }

    /**
     * Writing elements to the table
     * @param word value of an element
     */
    public void add(String word) {

        int index = hash.countHash(word, size);
        currentSize = elements[index].push(word, currentSize);
    }

    /**
     * Delete number from the table
     * @param word value of an element
     */
    public void remove(String word) {

        int index = hash.countHash(word, size);
        currentSize = elements[index].delete(word, currentSize);
    }

    /**
     * Search an element in the table
     * @param word value of an element
     * @return return true if element in the table
     */
    public boolean find(String word) {

        int index = hash.countHash(word, size);
        return elements[index].find(word);
    }

    /**
     * Change hash
     * @param hash new hash
     */
    public void chooseHash(HashFunction hash) {

        this.hash = hash;
        List[] newArray = new List[size];
        for (int i = 0; i < size; i++)
            newArray[i] = new List();
        for (int i = 0; i < size; i++) {
            while (!elements[i].isEmpty()) {
                String word = elements[i].pop();
                int index = hash.countHash(word, size);
                newArray[index].push(word, currentSize);
            }
        }
        elements = newArray;
        return;
    }

    /** Print statistics of the table */
    public void printStatistics() {
        numberOfConflicts = 0;
        maxLength = 0;
        System.out.println(currentSize);
        System.out.println("Size: " + size + "\nLoad factor: " + (float) currentSize / size);
        for (int i = 0; i < size; i++) {
            int number = elements[i].count();
            if (number > maxLength)
                maxLength = number;
            if (number > 1) {
                numberOfConflicts += number - 1;
            }
        }
        System.out.println("Number of conflicts: " + numberOfConflicts + "\nMaximum list length in conflicting cells: " + maxLength);
    }
}
