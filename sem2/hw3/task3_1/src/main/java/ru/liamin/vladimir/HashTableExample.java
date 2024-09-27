package ru.liamin.vladimir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** HashTable example class */
public class HashTableExample {

    /**
     * HashTable example method
     * @param args args array of arguments
     * @throws FileNotFoundException is not file exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("0 - exit");
        System.out.println("1 - add");
        System.out.println("2 - remove");
        System.out.println("3 - found");
        System.out.println("4 - statistics");
        System.out.println("5 - push from file");
        System.out.println("6 - choose a hash");

        HashTable hashTable = new HashTable();
        int numberOfHash = 1;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Your choice: ");
            Scanner in = new Scanner(System.in);
            int i = in.nextInt();
            switch (i) {
                case 0:
                    isExit = true;
                    break;
                case 1:
                    System.out.println("Your word: ");
                    String word = in.next();
                    hashTable.add(word);
                    break;
                case 2:
                    System.out.println("Your word: ");
                    word = in.next();
                    hashTable.remove(word);
                    break;
                case 3:
                    System.out.println("Your word: ");
                    word = in.next();
                    boolean findElement = hashTable.find(word);
                    if (findElement) {
                        System.out.println("YES");
                        break;
                    }
                    System.out.println("NO");
                    break;
                case 4:
                    hashTable.printStatistics();
                    break;
                case 5:
                    Scanner scanner = new Scanner(new File("D:\\java\\hw3\\task3_1\\src\\main\\java\\ru\\liamin\\vladimir\\text.txt"));
                    while (scanner.hasNext()) {
                        word = scanner.next();
                        hashTable.add(word);
                    }
                    break;
                case 6:
                    System.out.println("1 - quickly hash");
                    System.out.println("2 - effective hash");
                    HashFunction hash;
                    numberOfHash = in.nextInt();
                    if (numberOfHash == 1)
                        hash = new HashQuickly();
                    else
                        hash = new HashEffective();
                        hashTable.chooseHash(hash);
            }
        }
    }
}
