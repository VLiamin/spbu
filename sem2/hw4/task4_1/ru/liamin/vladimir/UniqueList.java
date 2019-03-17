package ru.liamin.vladimir;

/** Implementation of a unique list */
public class UniqueList<T> {
    private int size;
    private ListElement head;

    /**
     * Writing elements to the list
     * @param value value of an element
     * @param currentSize amount of elements
     * @return amount of elements
     * @throws ElementAlreadyExistsExeption exception report having duplicate
     */
    public int push(T value, int currentSize) throws ElementAlreadyExistsExeption {

        if (size == 0) {
            head = new ListElement(value, head);
            size++;
            return ++currentSize;
        }

        ListElement temp = head;

        for (int i = 0; i < size - 1; i++) {
            if (temp.value == value)
                    throw new ElementAlreadyExistsExeption("This item is already there");
            temp = temp.next;
        }

        if (temp.value == value)
            throw new ElementAlreadyExistsExeption("This item is already there");
        size++;
        temp.next = new ListElement(value, temp.next);
        return ++currentSize;
    }

    /**
     * Delete an element in list
     * @param number value of an element
     * @param currentsize amount of elements
     * @return new amount of elements exception report about missing element
     * @throws ElementDoesNotExistExeption
     */
    public int delete(T number, int currentsize) throws ElementDoesNotExistExeption {
        ListElement temp = head;
        if (size == 0){
            throw new ElementDoesNotExistExeption("This item is not there");
        }

        if (head.value == number){
            head = head.next;
            size--;
            return currentsize - 1;
        }

        while ((temp.next != null) && (temp.next.value != number))
            temp = temp.next;

        if (temp.next == null) {
            throw new ElementDoesNotExistExeption("This item is not there");
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
    public boolean find(T number){
        for (int i = 0; i < size; i++){
            if (head.value == number)
                return true;
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