package ru.liamin.vladimir;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BuildGraph buildGraph = new BuildGraph();
        Statement statement = null;

        List<Subgraph> list = buildGraph.build("text.txt");
        int max = findMax(list);
            for (int i = 0; i < max; i++) {
                System.out.print("<" + Statement.returnStatement("").getStatement() + "> " + i + ": ");
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j).getLineList().get(i % list.get(j).getLineList().size()).getLine());
                }
                System.out.println();
            }
    }

    public static int findMax(List<Subgraph> list) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i).getLineList().size();
            if (temp > max)
                max = temp;
            temp = 0;
        }
        return max;
    }
}
