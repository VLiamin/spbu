package ru.liamin.vladimir;

import java.util.ArrayList;

/** Class realizing the spread of the virus on the network */
public class ComputerNetwork {

    private int[][] matrix;
    private ArrayList<Computer> computers = new ArrayList<>();

    public ComputerNetwork(int[][] matrix, ArrayList<Computer> computers) {
        this.matrix = matrix;
        this.computers = computers;
    }

    /**
     * Method realizing the spread of the virus on the networ
     * @return the array of computers
     */
    public ArrayList<Computer> infect() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < computers.size(); j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (matrix[j][k] == 1) {
                        if ((computers.get(j).getIsInfected()) && (!computers.get(j).getIsInfectedOnThisStep()) && (!computers.get(k).getIsInfected())) {
                            computers.get(k).infect();
                        } else if ((!computers.get(j).getIsInfected()) && (!computers.get(k).getIsInfectedOnThisStep()) && (computers.get(k).getIsInfected())) {
                            computers.get(j).infect();
                        }
                    }
                }
            }
            for (int j = 0; j < computers.size(); j++) {
                computers.get(j).setIsInfectedOnThisStep(false);
            }
        }
        return computers;
    }

}
