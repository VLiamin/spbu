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
    public int push(int value, int currentSize) {

        if (size == 0) {
            head = new ListElement(value, head);
            size++;
            return ++currentSize;
        }

        ListElement temp = head;

        for (int i = 0; i < size - 1; i++) {
            if (temp.value == value){
                try {
                    throw new DuplicateFormatFlagsException("Also");
                }
                finally {
                    System.out.println("Has also");
                    return currentSize;
                }
            }
            temp = temp.next;
        }

        if (temp.value == value)
        {
            try {
                throw new DuplicateFormatFlagsException("Also");
            }
            finally {
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
     * @param number value of an element
     * @param currentsize amount of elements
     * @return new amount of elements
     */
    public int delete(int number, int currentsize) {
        ListElement temp = head;
        if (size == 0){
            System.out.println("Not found");
            return currentsize;
        }

        if (head.value == number){
            head = head.next;
            size--;
            return currentsize - 1;
        }

        while ((temp.next != null) && (temp.next.value != number))
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
     * @param number value of an element
     * @return true if an element in list
     */
    public boolean find(int number){
        for (int i = 0; i < size; i++){
            if (head.value == number)
                return true;
        }
        return false;
    }

    /**
     * Returns the value and deletes the element
     * @return number value of an element
     */
    public int pop(){
        if (head != null){
            int value = head.value;
            head = head.next;
            return value;
        }
        return 0;
    }

    /** Clear list */
    public void clear() {
        size = 0;
        head = null;

    }

    private class ListElement {
        private int value;
        private ListElement next;

        public ListElement(int number, ListElement next) {
            value = number;
            this.next = next;
        }
    }
}