package ru.liamin.vladimir;

/**
 * Made in the form of sorting inserts
 */
public class Insert implements SortArray {
    private int i = 0;
    private int j = 0;
    private static int temp = 0;

    /**
     * Array sorting method
     * @param arrayOfNumbers Array of elements
     * @return Returns a sorted array
     */
    public int[] run(int[] arrayOfNumbers) {
        System.out.println("\nInsert sorting");
        int[] copyOfArray = arrayOfNumbers.clone();
        for (i = 1; i < copyOfArray.length; i++){
            j = i - 1;
            temp = copyOfArray[i];
            while (j > 0 && copyOfArray[j] > temp){
                copyOfArray[j + 1] = copyOfArray[j];
                j--;
            }
        }
        copyOfArray[j] = temp;
        System.out.println();
        return copyOfArray;
    }

    /**
     * Entering elements and starting sorting
     * @param args array of arguments
     */
    public static void main(String[] args) {
        int[] arrayOfNumbers = {2, 5, 1, 3, 7};

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
        System.out.println();
        Insert insert = new Insert();
        arrayOfNumbers = insert.run(arrayOfNumbers);
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }
}
