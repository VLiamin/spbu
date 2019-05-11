package ru.liamin.vladimir;

/** Made in the form of sorting inserts */
public class InsertSort implements SortArray {


    /**
     * Array sorting method
     * @param arrayOfNumbers Array of elements
     * @return Returns a sorted array
     */
    public void sort(int[] arrayOfNumbers) {

        int temp = 0;
        int i = 0;
        int j = 0;
        for (i = 1; i < arrayOfNumbers.length; i++) {
            j = i;
            temp = arrayOfNumbers[i];
            while (j > 0 && arrayOfNumbers[j - 1] > temp) {
                arrayOfNumbers[j] = arrayOfNumbers[j - 1];
                j--;
            }
            arrayOfNumbers[j] = temp;
        }
    }
}