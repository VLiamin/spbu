package ru.liamin.vladimir;

import javafx.scene.control.TextArea;

/** Implementation of a unique list */
public class List {
    private int size;
    private ListElement head;

    /**
     * Adding element to the list
     * @param value value of an element
     * @param sign sign of an operation
     * @param count variable to add multivalued numbers
     */
    public void push(double value, char sign, int count) {
        if (head == null) {
            head = new ListElement(value, sign, null);
            size++;
            return;
        }


        ListElement last = head;
        if (head != null)
            while (last.next != null)
                last = last.next;

        if (((count % 2 == 0) && (last.sign == 'b')) || ((count % 2 == 1) && (last.sign != 'b'))) {

            if (last != null)

                last.next = new ListElement(value, sign, null);
            size++;
        } else if (sign == 'b')
            last.value = last.value * 10 + value;
        else
            last.sign = sign;

        return;
    }

    /**
     * Returns an operation sign
     * @return sign of an operation
     */
    public char removeSign() {

        return head.sign;
    }

    /**
     * Remove the element of list
     * @return value of the element
     */
    public double pop() {
        try {
            double value = head.value;
            size--;
            head = head.next;
            return value;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * Count of elements in list
     * @return number of elements in list
     */
    public int count() {
        return size;
    }

    /**
     * Print list elements
     * @param textArea variable needed to display text on the screen
     */
    public void printList(TextArea textArea) {
        ListElement current = head;
        String str = new String();
        while (current != null) {

            if (current.sign != 'b')
                str = str + " " + current.sign;
            else
                str = str + " " + current.value;
            current = current.next;
        }
        textArea.setText(str);
    }

    /** Sort numbers with operations */
    public void sortList() {
        ListElement current = head;
        char sign = 'b';
        while (current != null) {

            if ((current.sign == '+') || (current.sign == '-')) {
                current.value = current.next.value;
                current.next.value = 0;

                if (sign != 'b') {
                    char temp = current.sign;
                    current.sign = 'b';
                    current.next.sign = sign;
                    sign = temp;
                    current = current.next.next;
                } else {

                    sign = current.sign;
                    current.sign = 'b';
                    current.next = current.next.next;
                    current = current.next;
                }
                continue;
            }

            if ((current.sign == '*') || (current.sign == '/')) {

                current.value = current.next.value;
                current.next.sign = current.sign;
                current.sign = 'b';
                current.next.value = 0;
                current = current.next.next;
                continue;
            }

            if (current != null)
                current = current.next;
        }

        if (sign != 'b') {
            current = head;
            while (current.next != null)
                current = current.next;
            current.next = new ListElement(0, sign, null);
        }
    }

    /** Clear list */
    public void clear() {
        size = 0;
        head = null;

    }

    private class ListElement {
        private double value;
        private ListElement next;
        private char sign;

        public ListElement(double number, char sign, ListElement next) {
            value = number;
            this.next = next;
            this.sign = sign;
        }
    }
}