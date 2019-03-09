package ru.liamin.vladimir;

/** Class designed to display items on the console */
public class PrintOnConsole implements Array {

    /**
     * Displays the elements of the matrix to the console
     * @param elements elements in the matrix when traversing it through the cycle
     */
    public void print(int[] elements){
        for (int i = 0; i < elements.length; i++){
            System.out.print(elements[i] + " ");
        }
    }
}
