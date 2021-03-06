package ru.liamin.vladimir;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


class ComputerNetworkTest {

    @Test
    void getFirstInfectCorrectnessTest() throws IOException {
        ComputerExample computerExample = new ComputerExample();
        int[][] matrix = computerExample.initialiseMatrix("src\\test\\java\\ru\\liamin\\vladimir\\matrix.txt");
        ArrayList<Computer> arrayList = new ArrayList<>();
        HashMap<Software, Double> hashMap = new HashMap<>();
        hashMap.put(Software.Windows, 1.0);
        arrayList.add(new Computer(Software.Windows,  true, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows, false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows,  false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows,  false, hashMap, new NetworkRandom()));
        ComputerNetwork computerNetwork = new ComputerNetwork(matrix, arrayList);
        computerNetwork.infect();
        assertEquals(true, arrayList.get(0).getIsInfected());
        assertEquals(true, arrayList.get(1).getIsInfected());
        assertEquals(true, arrayList.get(2).getIsInfected());
        assertEquals(true, arrayList.get(3).getIsInfected());
    }

    @Test
    void getSecondInfectCorrectnessTest() throws IOException {
        ComputerExample computerExample = new ComputerExample();
        int[][] matrix = computerExample.initialiseMatrix("src\\test\\java\\ru\\liamin\\vladimir\\matrix.txt");
        ArrayList<Computer> arrayList = new ArrayList<>();
        HashMap<Software, Double> hashMap = new HashMap<>();
        hashMap.put(Software.Windows, 0.0);
        arrayList.add(new Computer(Software.Windows,  true, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows, false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows,  false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows,  false, hashMap, new NetworkRandom()));
        ComputerNetwork computerNetwork = new ComputerNetwork(matrix, arrayList);
        computerNetwork.infect();
        assertEquals(true, arrayList.get(0).getIsInfected());
        assertEquals(false, arrayList.get(1).getIsInfected());
        assertEquals(false, arrayList.get(2).getIsInfected());
        assertEquals(false, arrayList.get(3).getIsInfected());
    }

    @Test
    void getThirdInfectCorrectnessTest() throws IOException {
        ComputerExample computerExample = new ComputerExample();
        int[][] matrix = computerExample.initialiseMatrix("src\\test\\java\\ru\\liamin\\vladimir\\matrix.txt");
        ArrayList<Computer> arrayList = new ArrayList<>();
        HashMap<Software, Double> hashMap = new HashMap<>();
        hashMap.put(Software.Windows, 0.0);
        hashMap.put(Software.Linux, 1.0);
        arrayList.add(new Computer(Software.Windows,  true, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows, false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Linux,  false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows,  false, hashMap, new NetworkRandom()));
        ComputerNetwork computerNetwork = new ComputerNetwork(matrix, arrayList);
        computerNetwork.infect();
        assertEquals(true, arrayList.get(0).getIsInfected());
        assertEquals(false, arrayList.get(1).getIsInfected());
        assertEquals(true, arrayList.get(2).getIsInfected());
        assertEquals(false, arrayList.get(3).getIsInfected());
    }

    // Shows that the virus does not spread to computers not related to infected
    @Test
    void getFourthInfectCorrectnessTest() throws IOException {
        ComputerExample computerExample = new ComputerExample();
        int[][] matrix = computerExample.initialiseMatrix("src\\test\\java\\ru\\liamin\\vladimir\\matrix2.txt");
        ArrayList<Computer> arrayList = new ArrayList<>();
        HashMap<Software, Double> hashMap = new HashMap<>();
        hashMap.put(Software.Windows, 1.0);
        arrayList.add(new Computer(Software.Windows,  true, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows, false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows,  false, hashMap, new NetworkRandom()));
        arrayList.add(new Computer(Software.Windows,  false, hashMap, new NetworkRandom()));
        ComputerNetwork computerNetwork = new ComputerNetwork(matrix, arrayList);
        computerNetwork.infect();
        assertEquals(true, arrayList.get(0).getIsInfected());
        assertEquals(true, arrayList.get(1).getIsInfected());
        assertEquals(true, arrayList.get(2).getIsInfected());
        assertEquals(false, arrayList.get(3).getIsInfected());
    }

    //Shows correct doing then virus infections
    @Test
    void getFifthInfectCorrectnessTest() throws IOException {
        ComputerExample computerExample = new ComputerExample();
        int[][] matrix = computerExample.initialiseMatrix("src\\test\\java\\ru\\liamin\\vladimir\\matrix2.txt");
        ArrayList<Computer> arrayList = new ArrayList<>();
        HashMap<Software, Double> hashMap = new HashMap<>();
        hashMap.put(Software.Windows, 0.3);
        hashMap.put(Software.Linux, 0.5);
        arrayList.add(new Computer(Software.Windows, true, hashMap, new RandomForTests()));
        arrayList.add(new Computer(Software.Linux, false, hashMap, new RandomForTests()));
        arrayList.add(new Computer(Software.Windows, false, hashMap, new RandomForTests()));
        arrayList.add(new Computer(Software.Windows, false, hashMap, new RandomForTests()));
        ComputerNetwork computerNetwork = new ComputerNetwork(matrix, arrayList);
        computerNetwork.infect();
        assertEquals(true, arrayList.get(0).getIsInfected());
        assertEquals(true, arrayList.get(1).getIsInfected());
        assertEquals(false, arrayList.get(2).getIsInfected());
        assertEquals(false, arrayList.get(3).getIsInfected());
    }

    @Test
    void getSixthInfectCorrectnessTest() throws IOException {
        ComputerExample computerExample = new ComputerExample();
        int[][] matrix = computerExample.initialiseMatrix("src\\test\\java\\ru\\liamin\\vladimir\\matrix.txt");
        ArrayList<Computer> arrayList = new ArrayList<>();
        HashMap<Software, Double> hashMap = new HashMap<>();
        hashMap.put(Software.Windows, 0.3);
        hashMap.put(Software.Linux, 0.5);
        arrayList.add(new Computer(Software.Windows, true, hashMap, new RandomForTests()));
        arrayList.add(new Computer(Software.Linux, false, hashMap, new RandomForTests()));
        arrayList.add(new Computer(Software.Linux, false, hashMap, new RandomForTests()));
        arrayList.add(new Computer(Software.Windows, false, hashMap, new RandomForTests()));
        ComputerNetwork computerNetwork = new ComputerNetwork(matrix, arrayList);
        computerNetwork.infect();
        assertEquals(true, arrayList.get(0).getIsInfected());
        assertEquals(true, arrayList.get(1).getIsInfected());
        assertEquals(true, arrayList.get(2).getIsInfected());
        assertEquals(false, arrayList.get(3).getIsInfected());
    }
}