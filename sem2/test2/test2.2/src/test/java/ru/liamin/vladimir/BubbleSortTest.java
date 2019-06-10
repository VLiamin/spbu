package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sortArrayInteger() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(15);
        list.add(8);
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((int) o1 > (int) o2)
                    return 1;
                else if ((int) o1 == (int) o2)
                    return 0;
                return -1;
            }
        };

        bubbleSort.sortArray(list, comparator);
        Object[] array = list.toArray();
        Object[] sample = {15, 12, 8};
        assertArrayEquals(array, sample);
    }

    @Test
    void sortArrayChar() {
        List<Character> list = new ArrayList<>();
        list.add('z');
        list.add('b');
        list.add('a');
        BubbleSort<Character> bubbleSort = new BubbleSort<>();
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.hashCode() > o2.hashCode())
                    return 1;
                else if (o1.hashCode() == o2.hashCode())
                    return 0;
                return -1;
            }
        };

        bubbleSort.sortArray(list, comparator);
        Object[] array = list.toArray();
        Object[] sample = {'z', 'b', 'a'};
        assertArrayEquals(array, sample);
    }
}