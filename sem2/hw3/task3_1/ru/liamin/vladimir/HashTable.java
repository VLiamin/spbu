package ru.liamin.vladimir;

/** Implementation hash table */
public class HashTable {
    private Hash hash;
    private int size;
    private int currentSize;
    private int numberOfConflicts;
    private int maxLength;
    private List[] list;

    public HashTable() {
        size = 100;
        list = new List[size];
        for (int i = 0; i < size; i++)
            list[i] = new List();
    }

    /**
     * Writing elements to the table
     * @param number value of an element
     * @param numberOfHash hash number used
     */
    public void push(int number, int numberOfHash) {

        int index = 0;
        switch (numberOfHash) {
            case 1:
                hash = new HashQuickly();
                index = hash.countHash(number);
                break;
            case 2:
                hash = new HashLong();
                index = hash.countHash(number);
                break;
        }
        currentSize = list[index].push(number, currentSize);
    }

    /**
     * Delete number from the table
     * @param number value of an element
     * @param numberOfHash hash number used
     */
    public void pop(int number, int numberOfHash) {

        int index = 0;
        switch (numberOfHash) {
            case 1:
                hash = new HashQuickly();
                index = hash.countHash(number);
                break;
            case 2:
                hash = new HashLong();
                index = hash.countHash(number);
                break;
        }
        currentSize = list[index].delete(number, currentSize);
    }

    /**
     * Search an element in the table
     * @param number value of an element
     * @param numberOfHash hash number used
     * @return return true if element in the table
     */
    public boolean find(int number, int numberOfHash) {

        int index = 0;
        switch (numberOfHash) {
            case 1:
                hash = new HashQuickly();
                index = hash.countHash(number);
                break;
            case 2:
                hash = new HashLong();
                index = hash.countHash(number);
                break;
        }
        return list[index].find(number);
    }

    /**
     * Change hash
     * @param numberOfHash number of the new hash
     * @return new hash
     */
    public HashTable chooseHash(int numberOfHash){

        int index = 0;
        int number = 0;
        HashTable hashTable = new HashTable();
        for(int i = 0; i < size; i++){
            while (!list[i].isEmpty()){
                switch (numberOfHash) {
                    case 1:
                        hash = new HashQuickly();
                        number = list[i].pop();
                        index = hash.countHash(number);
                        break;
                    case 2:
                        hash = new HashLong();
                        number = list[i].pop();
                        index = hash.countHash(number);
                        break;
                }
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
        for (int i = 0; i < size; i++){
            int number = list[i].count();
            if (number > maxLength)
                maxLength = number;
            if (number > 1){
                numberOfConflicts += number - 1;
            }
        }
        System.out.println("Number of conflicts: " + numberOfConflicts + "\nMaximum list length in conflicting cells: " + maxLength);
    }
}
