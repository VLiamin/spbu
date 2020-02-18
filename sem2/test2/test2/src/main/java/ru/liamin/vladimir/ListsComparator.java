package ru.liamin.vladimir;

import java.util.LinkedList;

/** Interface which compare linkedLists */
public interface ListsComparator {
    /**
     * Method compare LinkedLists
     * @param linkedList1 first linkedList
     * @param linkedList2 second linkedList
     * @return which LinkedList bigger
     */
    int compare(LinkedList linkedList1, LinkedList linkedList2);
}
