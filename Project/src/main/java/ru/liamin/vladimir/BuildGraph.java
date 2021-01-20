package ru.liamin.vladimir;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildGraph {

    public void build(String name) throws IOException {
        FileReader fileReader = new FileReader(name);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        Statement statement = null;
        List<Subgraph> subgraphList = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {
            int i = 0;
            while (s.charAt(i) != '\n') {
                if (s.charAt(i) == '.')
                    break;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                if (s.charAt(i) > 'a' && s.charAt(i) < 'z' && statement == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (s.charAt(i) != ' ') {
                        stringBuilder.append(s.charAt(i));
                        i++;
                    }
                    continue;
                }

                if (s.charAt(i) == '*') {
                    i++;
                }

                if (s.charAt(i) == '(') {
                    if (s.charAt(i - 1) == '*') {
                        subgraphList.add(new Subgraph(true));
                    } else {
                        subgraphList.add(new Subgraph(false));
                    }
                    i++;
                }

                if (s.charAt(i) == ')') {
                    int j = subgraphList.size();
                    while (true) {
                        if (subgraphList.get(j - 1).isEnd() == false) {
                            subgraphList.get(j - 1).setEnd(false);
                            break;
                        }
                        j--;
                    }
                }
                if (subgraphList.get(subgraphList.size() - 1).getLineList().size() == 0)
                    subgraphList.get(subgraphList.size() - 1).addLine(new Line());
                Subgraph subgraph = subgraphList.get(subgraphList.size() - 1);
                if (s.charAt(i) == '$') {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (s.charAt(i) != ' ') {
                        stringBuilder.append(s.charAt(i));
                        i++;
                    }
                    subgraph.getLineList().get(subgraph.getLineList().size() - 1).
                }

            }
        }
        bufferedReader.close();
    }
}
