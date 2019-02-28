package ru.liamin.vladimir;

/**
 * Made in the form of bubble sort
 */
public class Bubble implements SortArray {
    private int i = 0;
    private int j = 0;
    private static int temp = 0;

    /**
     * Array sorting method
     * @param arrayOfNumbers Array of elements
     * @return Returns a sorted array
     */
    public int[] run(int[] arrayOfNumbers) {
        System.out.print("\nBubble sort");
        int[] copyOfArray = arrayOfNumbers.clone();
        for (i = 0; i < copyOfArray.length; i++) {
            for (j = 0; j < copyOfArray.length; j++) {
                if (copyOfArray[i] > copyOfArray[j]) {
                    temp = copyOfArray[i];
                    copyOfArray[i] = copyOfArray[j];
                    copyOfArray[j] = temp;
                }
            }
        }

        System.out.println();
        return copyOfArray;
    }

    /**
     * Entering elements and starting sorting
     * @param args array of arguments
     */
    public static void main(String[] args) {
        int[] arrayOfNumbers = {2, 4, 1, 3, 7};

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
        System.out.println();
        Bubble bubble = new Bubble();
        arrayOfNumbers = bubble.run(arrayOfNumbers);
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }
}
