package ru.liamin.vladimir;

public class UniversityTrip {
    private int numberOfBuses;

    public UniversityTrip(int numberOfBuses) {
        this.numberOfBuses = numberOfBuses;
    }
    public int go() {
        int time = numberOfBuses * 45 + (14 * numberOfBuses - 1);
        return time;
    }
}
