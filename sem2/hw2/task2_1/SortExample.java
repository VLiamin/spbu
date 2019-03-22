package ru.liamin.vladimir;

/** Sorting implementation example */
public class SortExample {

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
        System.out.print("\nBubble sort");
        Bubble bubble = new Bubble();
        bubble.run(arrayOfNumbers);
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }

        System.out.println();
        System.out.println("\nInsert sorting");
        Insert insert = new Insert();
        insert.run(arrayOfNumbers);
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }
}
