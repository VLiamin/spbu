package ru.liamin.vladimir;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.StrictMath.abs;

public final class SecondPartTasks {

    private SecondPartTasks() {}

    // Найти строки из переданных файлов, в которых встречается указанная подстрока.
    public static List<String> findQuotes(List<String> paths, CharSequence sequence) {
        return paths.stream().filter(string -> string.contains(sequence)).collect(Collectors.toList());
    }

    // В квадрат с длиной стороны 1 вписана мишень.
    // Стрелок атакует мишень и каждый раз попадает в произвольную точку квадрата.
    // Надо промоделировать этот процесс с помощью класса java.util.Random и посчитать, какова вероятность попасть в мишень.
    public static double piDividedBy4() {

        Random random = new Random();
        int happening = 1000;
        return (double) IntStream.range(1, happening).filter(hit -> {

            Double radius = 0.5;
            double x = random.nextDouble() % 1;
            double y = random.nextDouble() % 1;

            x = abs(x) - radius;
            y = abs(y) - radius;

            return (x * x) + (y * y) <= (radius * radius);
        }).count() / happening;
    }

    // Дано отображение из имени автора в список с содержанием его произведений.
    // Надо вычислить, чья общая длина произведений наибольшая.
    public static String findPrinter(Map<String, List<String>> compositions) {

        return compositions.entrySet().stream()
                .max(Comparator.comparing(writer -> writer.getValue().stream()
                        .mapToInt(String::length).sum())).get().getKey();
    }

    // Вы крупный поставщик продуктов. Каждая торговая сеть делает вам заказ в виде Map<Товар, Количество>.
    // Необходимо вычислить, какой товар и в каком количестве надо поставить.
    public static Map<String, Integer> calculateGlobalOrder(List<Map<String, Integer>> orders) {

        return orders.stream().flatMap(order -> order.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue + newValue));
    }
}