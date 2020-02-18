package ru.liamin.vladimir;

/** Single-thread sorting implementation class */
public class QuickSort implements Sorter {

    /**
     * Sorting class
     * @param numbers array which sorted
     */
    @Override
    public void sort(int[] numbers) {

        sortArray(0, numbers.length - 1, numbers);
    }

    private void sortArray(int left, int right, int[] nubers) {

        if (right - left < 10) {

            insertSort(left, right, nubers);
            return;
        }
        int tmp = 0;
        int l = left;
        int r = right;
        int middle = nubers[left];
        while (right > left) {
            while ((nubers[right] >= middle) & (right > left)) {
                right--;
            }
            while ((nubers[left] <= middle) & (right > left)) {
                left++;
            }
            if (right > left) {
                tmp = nubers[right];
                nubers[right] = nubers[left];
                nubers[left] = tmp;
            }
        }
        tmp = nubers[left];
        nubers[left] = middle;
        nubers[l] = tmp;

        middle = left;
        left = l;
        right = r;

        if (middle - left > 0) {
            sortArray(left, middle - 1, nubers);
        }
        if (right - middle > 0) {
            sortArray(middle + 1, right, nubers);
        }
    }

    public void insertSort(int left, int right, int[] nubers) {

        for (int i = left + 2; i < right; i++) {
            int x = nubers[i];
            int j = i;
            while ((j > 1) && (nubers[j - 1]) > x) {

                nubers[j] = nubers[j - 1];
                j--;
            }

            nubers[j] = x;
        }
    }
}
