package ru.liamin.vladimir;

/** Made in the form of sorting inserts */
public class Insert implements SortArray {
    private int i = 0;
    private int j = 0;
    private static int temp = 0;

    /**
     * Array sorting method
     * @param arrayOfNumbers Array of elements
     * @return Returns a sorted array
     */
    public void run(int[] arrayOfNumbers) {

        for (i = 1; i < arrayOfNumbers.length; i++){
            j = i;
            temp = arrayOfNumbers[i];
            while (j > 0 && arrayOfNumbers[j - 1] > temp){
                arrayOfNumbers[j] = arrayOfNumbers[j - 1];
                j--;
            }
            arrayOfNumbers[j] = temp;
        }
    }
}
