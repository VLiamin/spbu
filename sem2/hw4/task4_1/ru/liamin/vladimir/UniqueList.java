package ru.liamin.vladimir;

/**
 * Implementation of a unique list
 * @param <T> type of the element
 */
public class UniqueList<T> extends List {

    /**
     * Method which adding element to the unique list
     * @param value value of an element
     * @param index number of the element
     * @throws ElementAlreadyExistsExeption exception report having duplicate
     */
    @Override
    public void add(Object value, int index) throws ElementAlreadyExistsExeption {

        if (find(value))
            throw new ElementAlreadyExistsExeption("This item is already there");
        super.add(value, index);
    }
}
