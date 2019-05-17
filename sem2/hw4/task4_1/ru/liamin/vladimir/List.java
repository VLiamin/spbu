package ru.liamin.vladimir;

/** Implementation of a list */
public class List<T> {

    private int size;
    private ListElement head;

    /**
     * Writing elements to the list
     * @param value value of an element
     * @param index number of the element
     * throws ElementAlreadyExistsExeption exception report having duplicate
     */
    public void add(T value, int index) throws ElementAlreadyExistsExeption {

        if (size == 0) {
            head = new ListElement(value, head);
            size++;
            return;
        }

        ListElement temp = head;

        for (int i = 0; i < index - 2; i++) {
            temp = temp.next;
        }

        size++;
        temp.next = new ListElement(value, temp.next);
        return;
    }

    /**
     * Delete an element in list
     * @param number value of an element
     * @throws ElementDoesNotExistExeption
     */
    public void remove(T number) throws ElementDoesNotExistExeption {
        ListElement temp = head;
        if (!find(number)) {
            throw new ElementDoesNotExistExeption("This item is not there");
        }

        if (head.value == number) {
            head = head.next;
            size--;
            return;
        }

        while ((temp.next != null) && (temp.next.value != number))
            temp = temp.next;

        temp.next = temp.next.next;
        size--;
        return;
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
    public boolean find(T number) {
        ListElement temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == number)
                return true;
            temp = temp.next;
        }
        return false;
    }

    /** Clear list */
    public void clear() {
        size = 0;
        head = null;

    }

    private class ListElement<T> {
        private T value;
        private ListElement next;

        public ListElement(T number, ListElement next) {
            value = number;
            this.next = next;
        }
    }

}