package ru.liamin.vladimir;

/** Implementation hash table */
public class HashTable {
    private HashFunction hash;
    private int size = 100;
    private int currentSize;
    private int numberOfConflicts;
    private int maxLength;
    private List[] list;
    private int numberOfHash = 1;

    public HashTable() {

        hash = new HashQuickly();
        list = new List[size];
        for (int i = 0; i < size; i++)
            list[i] = new List();
    }

    /**
     * Writing elements to the table
     * @param number value of an element
     */
    public void add(int number) {

        int index = hash.countHash(number);
        currentSize = list[index].push(number, currentSize);
    }

    /**
     * Delete number from the table
     * @param number value of an element
     */
    public void remove(int number) {

        int index = hash.countHash(number);
        currentSize = list[index].delete(number, currentSize);
    }

    /**
     * Search an element in the table
     * @param number value of an element
     * @return return true if element in the table
     */
    public boolean find(int number) {

        int index = hash.countHash(number);
        return list[index].find(number);
    }

    /**
     * Change hash
     * @param numberOfHash number of the new hash
     * @return new hash
     */
    public HashTable chooseHash(int numberOfHash) {

        if (numberOfHash == this.numberOfHash)
            return this;
        HashTable hashTable = new HashTable();
        switch (numberOfHash) {
            case 1:
                hash = new HashQuickly();
                this.numberOfHash = numberOfHash;
                break;
            case 2:
                hash = new HashEffective();
                this.numberOfHash = numberOfHash;
                break;
        }
        for (int i = 0; i < size; i++) {
            while (!list[i].isEmpty()) {

                int number = list[i].pop();
                int index = hash.countHash(number);
                hashTable.list[index].push(number, currentSize);
            }
            list[i].clear();
        }
        hashTable.currentSize = currentSize;
        return hashTable;
    }

    /** Print statistics of the table */
    public void printStatistics() {
        numberOfConflicts = 0;
        maxLength = 0;
        System.out.println(currentSize);
        System.out.println("Size: " + size + "\nLoad factor: " + (float) currentSize / size);
        for (int i = 0; i < size; i++) {
            int number = list[i].count();
            if (number > maxLength)
                maxLength = number;
            if (number > 1) {
                numberOfConflicts += number - 1;
            }
        }
        System.out.println("Number of conflicts: " + numberOfConflicts + "\nMaximum list length in conflicting cells: " + maxLength);
    }
}
