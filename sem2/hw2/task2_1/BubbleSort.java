package ru.liamin.vladimir;

/** Made in the form of bubble sort */
public class BubbleSort implements SortArray {

    private static int temp = 0;

    /**
     * Array sorting method
     * @param arrayOfNumbers Array of elements
     * @return Returns a sorted array
     */
    public void sort(int[] arrayOfNumbers) {

        int i = 0;
        int j = 0;
        for (i = 0; i < arrayOfNumbers.length; i++) {
            for (j = 0; j < arrayOfNumbers.length; j++) {
                if (arrayOfNumbers[i] > arrayOfNumbers[j]) {
                    temp = arrayOfNumbers[i];
                    arrayOfNumbers[i] = arrayOfNumbers[j];
                    arrayOfNumbers[j] = temp;
                }
            }
        }
    }
}
