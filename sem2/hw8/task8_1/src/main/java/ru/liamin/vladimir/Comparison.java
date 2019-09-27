package ru.liamin.vladimir;

/** Class showing the time difference between multithreaded and single-threaded sorting implementation */
public class Comparison {
    /**
     * Method that compares a multithreaded and single-threaded implementation
     * @param args args array of arguments
     */
    public static void main(String[] args) {

        long quickTime = 0;
        long multithreadedQuickTime = 0;
        int[] numbers = new int[1000];

        System.out.println("Quick sort: ");
        Sorter quickSort = new QuickSort();
        Sorter multithreadedQuickSort = new MultithreadedQuickSort();
        for (int i = 0; i < 100; i++) {

            for (int j = 0; j < numbers.length; j++) {

                numbers[j] = (int) (Math.random() * 12);
            }

            int[] copyNumbers = new int[numbers.length];
            for (int j = 0; j < copyNumbers.length; j++) {

                copyNumbers[j] = numbers[j];
            }
            quickTime += sort(numbers, quickSort);
            multithreadedQuickTime += sort(copyNumbers, multithreadedQuickSort);
        }

        printTime(quickTime);
        System.out.println("Multithreaded quick sort: ");
        printTime(multithreadedQuickTime);
        System.out.print("Difference (quickTime - multithreadedQuickTime): " + (-multithreadedQuickTime + quickTime));
    }

    /**
     * Method which sort array
     * @param numbers array which we sorted
     * @param sorter sorting class
     * @return time it takes to implement
     */
    public static long sort(int[] numbers, Sorter sorter) {

        long start = System.currentTimeMillis();
        sorter.sort(numbers);
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    /**
     * Method which print time
     * @param time sorting time
     */
    private static void printTime(long time) {

        System.out.print("Time: " + time + '\n');
    }
}
