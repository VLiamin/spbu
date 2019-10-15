package ru.liamin.vladimir;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/** Class which shows system operation */
public class ComputerExample {
    /**
     * Method which shows system operation
     * @param args args array of arguments
     * @throws IOException exception required to check file for openness
     */
    public static void main(String[] args) throws IOException {
        ComputerExample computerExample = new ComputerExample();
        int[][] matrix = computerExample.initialiseMatrix("src\\matrix.txt");
        ArrayList<Computer> arrayList = new ArrayList<>();
        HashMap<Software, Double> hashMap = new HashMap<>();
        hashMap.put(Software.Windows, 0.3);
        hashMap.put(Software.Linux, 0.2);
        arrayList.add(new Computer(Software.Windows, true, hashMap));
        arrayList.add(new Computer(Software.Linux, false, hashMap));
        arrayList.add(new Computer(Software.Windows, false, hashMap));
        arrayList.add(new Computer(Software.Windows, false, hashMap));
        ComputerNetwork computerNetwork = new ComputerNetwork(matrix, arrayList);
        computerNetwork.infect();
        int i = 1;
        for (Computer computer : arrayList) {
            System.out.println(i + " computer is infected: " + computer.getIsInfected());
            i++;
        }
        System.out.println();
        computerNetwork.infect();
        i = 1;
        for (Computer computer : arrayList) {
            System.out.println(i + " computer is infected: " + computer.getIsInfected());
            i++;
        }
    }

    /**
     * Method which initialise matrix
     * @param name name of a file
     * @return matrix matrix which shows communication between computers
     * @throws IOException exception required to check file for openness
     */
    public int[][] initialiseMatrix(String name) throws IOException {
        Reader reader = new FileReader(name);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int number = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[number][number];
        int j = 0;
        while (bufferedReader.ready()) {
            String[] values = bufferedReader.readLine().split(" ");
            for (int i = 0; i < values.length; i++)
                matrix[j][i] = Integer.parseInt(values[i]);
            j++;
        }
        return matrix;
    }
}
