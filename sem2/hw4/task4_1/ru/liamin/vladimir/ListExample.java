package ru.liamin.vladimir;

/** List example class */
public class ListExample {
    /**
     * List example method
     * @param args args array of arguments
     */
    public static void main(String[] args) {
        UniqueList<Integer> uniqueList = new UniqueList<>();
        try {
            uniqueList.add(10, 0);
            uniqueList.add(10, 1);
        } catch (ElementAlreadyExistsExeption e) {
            System.out.println("This item is already there.");
        }
        try {
            uniqueList.add(11, 2);
        } catch (ElementAlreadyExistsExeption e) {
            System.out.println("This item is already there.");
        }

        uniqueList.printList();
        System.out.println(uniqueList.find(11));
        try {
            uniqueList.remove(11);
        } catch (ElementDoesNotExistExeption e) {
            System.out.println("This item is not there.");
        }

        try {
            uniqueList.remove(11);
        } catch (ElementDoesNotExistExeption e) {
            System.out.println("This item is not there.");
        }
        System.out.println("Size of list: " + uniqueList.count());
        System.out.println(uniqueList.isEmpty());
        uniqueList.clear();
    }
}
