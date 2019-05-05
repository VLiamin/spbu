package ru.liamin.vladimir;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniqueListTest {

    @Test
    public void testElementAlreadyExistsExeptionMessage() {
       UniqueList<Integer> uniqueList = new UniqueList<>();
       try {
           uniqueList.add(10, 0);
           uniqueList.add(10, 1);
           fail("Expected an ElementAlreadyExistsExeption to be thrown");
       } catch (ElementAlreadyExistsExeption e) {
           assertThat(e.getMessage(), is("This item is already there"));
       }
    }


    @Test
    public void testElementDoesNotExistExeptionMessage() {
        UniqueList<Integer> uniqueList = new UniqueList<>();
        try {
            uniqueList.remove(10);
        } catch (ElementDoesNotExistExeption e) {
            assertThat(e.getMessage(), is("This item is not there"));
        }
    }
}