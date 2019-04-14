package ru.liamin.vladimir;

/** List example class */
public class ListExample {
    /**
     * List example method
     * @param args args array of arguments
     */
    public static void main(String[] args) {
        UniqueList<Integer> uniqueList = new UniqueList<>();
        int curentSize = 0;
        try {
            curentSize = uniqueList.push(10, curentSize);
            curentSize = uniqueList.push(10, curentSize);
        } catch (ElementAlreadyExistsExeption e) {
            System.out.println("This item is already there.");
        }
        try {
            curentSize = uniqueList.push(11, curentSize);
        } catch (ElementAlreadyExistsExeption e) {
            System.out.println("This item is already there.");
        }

        uniqueList.printList();
        try {
            curentSize = uniqueList.delete(11, curentSize);
        } catch (ElementDoesNotExistExeption e) {
            System.out.println("This item is not there.");
        }

        try {
            curentSize = uniqueList.delete(11, curentSize);
        } catch (ElementDoesNotExistExeption e) {
            System.out.println("This item is not there.");
        }
        System.out.println("Size of list: " + uniqueList.count());
        System.out.println(uniqueList.isEmpty());
        uniqueList.clear();
    }
}
