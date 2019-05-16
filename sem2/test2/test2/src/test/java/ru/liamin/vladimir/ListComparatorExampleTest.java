package ru.liamin.vladimir;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ListComparatorExampleTest {

    @Test
    public void implementClassObjects() {
        String[] strings = new String[1];
        strings[0] = "hfdh  djdj djujud dju";
    //    strings[1] = "hjfdf dj";
        ListComparatorExample listComparatorExample = new ListComparatorExample();
        listComparatorExample.implementClassObjects(strings);
    }
}