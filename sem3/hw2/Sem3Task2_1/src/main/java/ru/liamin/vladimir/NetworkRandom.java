package ru.liamin.vladimir;

public class NetworkRandom implements Random {

    /**
     * Method which return random value
     * @return random value
     */
    @Override
    public double getRandom() {
        return Math.random();
    }
}
