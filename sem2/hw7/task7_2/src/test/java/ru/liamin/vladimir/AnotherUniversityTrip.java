package ru.liamin.vladimir;

public class AnotherUniversityTrip {
    private int numberOfBuses;

    public AnotherUniversityTrip(int numberOfBuses) {
        this.numberOfBuses = numberOfBuses;
    }
    public int go() {
        int time = numberOfBuses * 45 + (14 * numberOfBuses - 1);
        time = time + walk();
        return time;
    }

    private int walk() {
        return 20;
    }
}
