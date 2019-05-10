package ru.liamin.vladimir;

import java.util.LinkedList;

/** Class which implement strings to linkedLists */
public class ListComparatorExample {
    /**
     * Method which implement strings to linkedLists
     * @param strings strings which will be implement
     */
    public void implementClassObjects(String[] strings) {
        SortedSet sortedSet = new SortedSet();
        for (int i = 0; i < strings.length; i++) {
            LinkedList<String> linkedList = new LinkedList<>();
            int j = 0;
            char[] stringArray = strings[i].toCharArray();
            String word = new String();
            while (j < stringArray.length) {

                if ((word.length() != 0) && ((stringArray[j] == ' '))) {
                    linkedList.add(word + " ");
                    word = "";
                }
                else if ((stringArray[j] != ' ')) {
                    word = word + stringArray[j];
                }
                j++;
                if (j == stringArray.length) {
                    if (word.length() != 0)
                        linkedList.add(word + " ");
                }
            }
            sortedSet.add(linkedList);
        }
        System.out.print("1");
        sortedSet.print();
    }
}
