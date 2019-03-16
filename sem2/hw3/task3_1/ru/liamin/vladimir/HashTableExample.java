package ru.liamin.vladimir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTableExample {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("0 - exit");
        System.out.println("1 - push");
        System.out.println("2 - pop");
        System.out.println("3 - found");
        System.out.println("4 - statistics");
        System.out.println("5 - push from file");
        System.out.println("6 - choose a hash");

        HashTable hashTable = new HashTable();
        int numberOfHash = 1;
        boolean isExit = false;
        while (!isExit){
            System.out.println("Your choice: ");
            Scanner in = new Scanner(System.in);
            int i = in.nextInt();
            switch (i){
                case 0:
                    isExit = true;
                    break;
                case 1:
                    System.out.println("Your number: ");
                    int number = in.nextInt();
                    hashTable.push(number, numberOfHash);
                    break;
                case 2:
                    System.out.println("Your number: ");
                    number = in.nextInt();
                    hashTable.pop(number, numberOfHash);
                    break;
                case 3:
                    System.out.println("Your number: ");
                    number = in.nextInt();
                    boolean findElement = hashTable.find(number, numberOfHash);
                    if (findElement){
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
                    while(scanner.hasNextInt()) {
                        number = scanner.nextInt();
                        hashTable.push(number, numberOfHash);
                    }
                    break;
                case 6:
                    System.out.println("1 - quickly hash");
                    System.out.println("2 - long hash");
                    numberOfHash = in.nextInt();
                    hashTable = hashTable.chooseHash(numberOfHash);
            }
        }
    }
}
