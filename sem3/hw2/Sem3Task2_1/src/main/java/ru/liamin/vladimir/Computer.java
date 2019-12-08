package ru.liamin.vladimir;

import java.util.HashMap;

/** Class which shows information about computer */
public class Computer {
    private Software software;
    private double probability;
    private boolean isInfected;
    private boolean isInfectedOnThisStep = false;
    private Random random;

    public Computer(Software software, boolean isInfected, HashMap<Software, Double> softwareHashMap, Random random) {
        this.random = random;
        this.probability = softwareHashMap.get(software);
        this.software = software;
        this.isInfected = isInfected;
    }

    /**
     * Method which set statement computer infected or not
     * @param isInfected statement computer infected or not
     */
    public void setIsInfected(boolean isInfected) {
        this.isInfected = isInfected;
    }

    /**
     * Method which return statement computer infected or not
     * @return statement computer infected or not
     */
    public boolean getIsInfected() {
        return isInfected;
    }

    /**
     * Method set return statement computer infected on this step or not
     * @param isInfectedOnThisStep statement computer infected on this step or not
     */
    public void setIsInfectedOnThisStep(boolean isInfectedOnThisStep) {
        this.isInfectedOnThisStep = isInfectedOnThisStep;
    }

    /**
     * Method return return statement computer infected on this step or not
     * @return statement computer infected on this step or not
     */
    public boolean getIsInfectedOnThisStep() {
        return isInfectedOnThisStep;
    }

    /**
     * Method return likelihood of a computer becoming infected with a virus
     * @return likelihood of a computer becoming infected with a virus
     */
    public double getProbability() {
        return probability;
    }

    /**
     * Method return name of the software
     * @return name of the software
     */
    public Software getSoftware() {
        return software;
    }

    /** Method which checks if the computer is infected with a virus or not */
    public void infect() {

        if (random.getRandom() <= getProbability()) {
            isInfected = true;
            isInfectedOnThisStep = true;
        }
    }
}
