package ru.liamin.vladimir;

/*  Implementation of a unique list
 */

public class List {
    private int size;
    private ListElement top;

    private class ListElement {
        protected int value;
        protected ListElement next;

        public ListElement(int number, ListElement next) {
            this.value = number;
            this.next = next;
        }
    }

    public List() {
        size = 0;
        top = null;
    }

    public void push(int value, int index) {
        if (index > size || index < 0)
            return;
        size++;
        if (index == 0) {
            top = new ListElement(value, top);
            return;
        }

        ListElement temp = top;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = new ListElement(value, temp.next);
        return;
    }

    public int pop(int index) {
        if (index > size || index < 0)
        {
            System.out.println("Not found");
            return 0;
        }

        if (index == 0)
        {
            int number = top.value;
            top = top.next;
            return number;
        }
        else {
            ListElement temp = top;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            int number = temp.next.value;
            temp.next = temp.next.next;
            return number;
        }

    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int count() {
        return size;
    }

    public void printList() {
        System.out.println("Elements of list: ");
        ListElement current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void clear() {
        size = 0;
        top = null;

    }

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