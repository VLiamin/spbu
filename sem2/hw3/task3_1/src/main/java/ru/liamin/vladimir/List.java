package ru.liamin.vladimir;

import java.util.DuplicateFormatFlagsException;

/** Implementation of a unique list */
public class List {
    private int size;
    private ListElement head;

    /**
     * Writing elements to the list
     * @param value value of an element
     * @param currentSize amount of elements
     * @return new amount of elements
     */
    public int push(String value, int currentSize) {

        if (isEmpty()) {
            head = new ListElement(value, head);
            size++;
            return ++currentSize;
        }

        ListElement temp = head;

        for (int i = 0; i < size - 1; i++) {
            if (temp.value.equals(value)) {
                try {
                    throw new DuplicateFormatFlagsException("Also");
                } finally {
                    System.out.println("Has also");
                    return currentSize;
                }
            }
            temp = temp.next;
        }

        if (temp.value.equals(value)) {
            try {
                throw new DuplicateFormatFlagsException("Also");
            } finally {
                System.out.println("Has also");
                return currentSize;
            }

        }
        size++;
        temp.next = new ListElement(value, temp.next);
        return ++currentSize;
    }

    /**
     * Delete an element in list
     * @param word value of an element
     * @param currentsize amount of elements
     * @return new amount of elements
     */
    public int delete(String word, int currentsize) {
        ListElement temp = head;
        if (size == 0) {
            System.out.println("Not found");
            return currentsize;
        }

        if (head.value.equals(word)) {
            head = head.next;
            size--;
            return currentsize - 1;
        }

        while ((temp.next != null) && (temp.next.value.equals(word)))
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Not found");
            return currentsize;
        }
        temp.next = temp.next.next;
        size--;
        return currentsize - 1;
    }

    /**
     * Check for emptiness
     * @return return true if list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Count of elements in list
     * @return number of elements in list
     */
    public int count() {
        return size;
    }

    /** Print list element */
    public void printList() {
        System.out.println("Elements of list: ");
        ListElement current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    /**
     * Looks for an item in the list
     * @param word value of an element
     * @return true if an element in list
     */
    public boolean find(String word) {
        for (int i = 0; i < size; i++) {
            if (head.value.equals(word))
                return true;
        }
        return false;
    }

    /**
     * Returns the value and deletes the element
     * @return value of an element
     */
    public String pop() {
        if (!isEmpty()) {
            String value = head.value;
            head = head.next;
            size--;
            return value;
        }
        return "";
    }

    /** Clear list */
    public void clear() {
        size = 0;
        head = null;

    }

    private class ListElement {
        private String value;
        private ListElement next;

        public ListElement(String word, ListElement next) {
            value = word;
            this.next = next;
        }
    }
}