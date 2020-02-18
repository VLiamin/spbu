package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.lang.StrictMath.abs;
import static org.junit.Assert.assertEquals;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        List<String> strings = Arrays.asList("Misha", "Masha", "Katya", "Petya");

        assertEquals(Arrays.asList("Misha", "Masha"), SecondPartTasks.findQuotes(strings, "sh"));
        assertEquals(Arrays.asList("Katya"), SecondPartTasks.findQuotes(strings, "K"));
    }

    @Test
    public void testPiDividedBy4() {
        Double chance = SecondPartTasks.piDividedBy4();
        boolean isHit = false;

        if (abs(chance - 0.785) < 0.1)
            isHit = true;
        assertEquals(true, isHit);
    }

    @Test
    public void testFindPrinter() {
        List<String> martinBooks = Arrays.asList("Songs of Stars and Shadows", "A Song of Ice and Fire");
        List<String> bulgakovBooks = Arrays.asList("Master and Margarita", "Fatal eggs", "Dog's heart", "White Guard");
        List<String> tolstoyBooks = Arrays.asList("War and Peace", "Anna Karenina");

        Map<String, List<String>> compositions = new HashMap<>();
        compositions.put("Martin", martinBooks);
        compositions.put("Bulgakov", bulgakovBooks);
        compositions.put("Tolstoy", tolstoyBooks);

        assertEquals("Bulgakov", SecondPartTasks.findPrinter(compositions));
    }

    @Test
    public void testCalculateGlobalOrder() {

        List<Map<String, Integer>> orders = new ArrayList<>();

        Map<String, Integer> auchanOrder = new HashMap<>();
        auchanOrder.put("Milk", 5);
        auchanOrder.put("Water", 8);
        auchanOrder.put("Meat", 10);

        Map<String, Integer> magnitOrder = new HashMap<>();
        magnitOrder.put("Water", 4);
        magnitOrder.put("Meat", 6);
        magnitOrder.put("Bread", 2);

        Map<String, Integer> smmOrder = new HashMap<>();
        smmOrder.put("Water", 11);
        smmOrder.put("Bread", 1);
        smmOrder.put("Milk", 3);

        orders.add(auchanOrder);
        orders.add(magnitOrder);
        orders.add(smmOrder);

        Map<String, Integer> countOrder = new HashMap<>();
        countOrder.put("Milk", 8);
        countOrder.put("Water", 23);
        countOrder.put("Meat", 16);
        countOrder.put("Bread", 3);

        assertEquals(countOrder, SecondPartTasks.calculateGlobalOrder(orders));
    }
}