package ru.liamin.vladimir;

/** Implementation of a unique list */
public class List {
    private int size;
    private ListElement head;

    /**
     * Writing to the list
     * @param value record value
     * @param index index of an element
     */
    public void push(int value, int index) {
        if (index > size || index < 0)
            return;
        size++;
        if (index == 0) {
            head = new ListElement(value, head);
            return;
        }

        ListElement temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = new ListElement(value, temp.next);
        return;
    }

    /**
     * Returns the value and deletes the element
     * @param index index of an element
     * @return return value
     */
    public int pop(int index) {
        if (index > size || index < 0) {
            System.out.println("Not found");
            return 0;
        }

        if (index == 0) {
            int number = head.value;
            head = head.next;
            return number;
        }
        ListElement temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        int number = temp.next.value;
        temp.next = temp.next.next;
        return number;

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

    /**
     * Demonstrates ru.liamin.vladimir.List methods
     * @param args array of arguments
     */
    public static void main(String[] args) {
        List list = new List();
        list.push(10, 0);
        System.out.println("Value = " + list.pop(0));
        list.push(30, 0);
        System.out.println("Empty: " + list.isEmpty());
        list.push(20, 1);
        list.push(80, 1);
        System.out.println("Number = " + list.count());
        list.printList();
        list.clear();
        System.out.println("Empty: " + list.isEmpty());
    }

}