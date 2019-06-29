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
        newList(elements);
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
        currentSize = 0;

        List[] newArray = new List[size];
        List[] temp = elements;

        newList(newArray);

        elements = newArray;

        for (int i = 0; i < size; i++) {
            while (!temp[i].isEmpty()) {
                add(temp[i].pop());
            }
        }

        return;
    }

    private void newList(List[] lists) {

        for (int i = 0; i < size; i++) {

            lists[i] = new List();
        }

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