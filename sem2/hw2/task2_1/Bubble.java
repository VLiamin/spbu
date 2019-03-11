package ru.liamin.vladimir;

/** Made in the form of bubble sort */
public class Bubble implements SortArray {
    private int i = 0;
    private int j = 0;
    private static int temp = 0;

    /**
     * Array sorting method
     * @param arrayOfNumbers Array of elements
     * @return Returns a sorted array
     */
    public void run(int[] arrayOfNumbers) {

        for (i = 0; i < arrayOfNumbers.length; i++) {
            for (j = 0; j < arrayOfNumbers.length; j++) {
                if (arrayOfNumbers[i] > arrayOfNumbers[j]) {
                    temp = arrayOfNumbers[i];
                    arrayOfNumbers[i] = arrayOfNumbers[j];
                    arrayOfNumbers[j] = temp;
                }
            }
        }
        System.out.println();
    }
}
