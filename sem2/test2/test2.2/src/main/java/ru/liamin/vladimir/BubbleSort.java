package ru.liamin.vladimir;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Class that implements bubble sorting on lists
 * @param <T> element's type from the list
 */
public class BubbleSort<T> {

    /**
     * Method that implements bubble sorting on lists
     * @param list transferred list for sorting
     * @param comparator passed comparator to compare items
     */
    public void sortArray(List<T> list, Comparator<T> comparator) {

        if ((list == null) || (comparator == null))
            return;

        int size = list.size();
        ListIterator<T> listIterator1 =  list.listIterator();
        for (int i = 0; i < size - 1; i++) {
            T elementOne = listIterator1.next();
            for (int j = i + 1; j < size; j++) {

                ListIterator<T> listIterator2 =  list.listIterator();
                for (int l = 0; l < i - 1; l++) {
                    listIterator2.next();
                }
                T elementTwo = listIterator2.next();
                if (comparator.compare(elementOne, elementTwo) > 0) {
                    listIterator1.set(elementTwo);
                    listIterator2.set(elementOne);
                }

            }
        }

        return;
    }
}
