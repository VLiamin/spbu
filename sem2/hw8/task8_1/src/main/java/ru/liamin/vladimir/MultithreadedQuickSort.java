package ru.liamin.vladimir;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/** Multithreaded sorting implementation class */
public class MultithreadedQuickSort implements Sorter {

    private int[] array;

    /**
     * Sorting class
     * @param numbers array which sorted
     */
    @Override
    public void sort(int[] numbers) {

        array = numbers;
        ForkJoinPool.commonPool().invoke(new SortArray(0, numbers.length - 1));
    }

    private class SortArray extends RecursiveAction {

        private int right;
        private int left;
        private SortArray(int left, int right) {
            this.right = right;
            this.left = left;
        }
        @Override
        protected void compute() {

            if (right <= left)
                return;
            if (right - left < 10) {

                insertSort();
                return;
            }

            int tmp = 0;
            int l = left;
            int r = right;
            int middle = array[left];
            while (right > left)
            {
                while ((array[right] >= middle) & (right > left))
                {
                    right--;
                }
                while ((array[left] <= middle) &  (right > left))
                {
                    left++;
                }
                if 	(right > left)
                {
                    tmp = array[right];
                    array[right] = array[left];
                    array[left] = tmp;
                }
            }
            tmp = array[left];
            array[left] = middle;
            array[l] = tmp;

            middle = left;
            left = l;
            right = r;

            invokeAll(new SortArray(right, middle), new SortArray(middle + 1, left));
        }


        private void insertSort(){

            for (int i = left + 2; i < right; i++) {
                int x = array[i];
                int j = i;
                while ((j > 1) && (array[j - 1]) > x) {

                    array[j] = array[j - 1];
                    j--;
                }

                array[j] = x;
            }
        }
    }
}
