package ru.liamin.vladimir;

import java.util.LinkedList;

/**
 * Class sorted linkedLists
 */
public class SortedSet implements ListsComparator {
    private int size;
    private SortedSetElement head;

    /**
     * Method which added linkedList
     * @param linkedList linkedLists which will be added
     */
    public void add(LinkedList<String> linkedList) {
        size++;
        if (head == null) {
            head = new SortedSetElement(linkedList, null);
            return;
        }

        int j = 0;
        while ((j < size - 2) && (compare(head.next.value, linkedList) <= 0)) {

            head = head.next;
            j++;
        }
        head.next = new SortedSetElement(linkedList, head.next);
    }

    /** Method which print linkedLists */
    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < head.value.size(); j++)
                System.out.print(head.value.get(j)+ " ");
            System.out.print("\n");
            head = head.next;
        }
    }

    /**
     * Method which compare linkedLists
     * @param linkedList1 first linkedList
     * @param linkedList2 second linkedList
     * @return which linkedLists bigger
     */
    @Override
    public int compare(LinkedList linkedList1, LinkedList linkedList2) {
        if (linkedList1.size() == linkedList2.size())
            return 0;
        if (linkedList1.size() > linkedList2.size())
            return 1;
        return 2;
    }

    private class SortedSetElement {
        private LinkedList<String> value;
        private SortedSetElement next;

        public SortedSetElement(LinkedList<String> value, SortedSetElement next) {
            this.value = value;
            this.next = next;
        }
    }
}
