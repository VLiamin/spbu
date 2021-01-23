package ru.liamin.vladimir;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuildGraph {

    public List<Subgraph> build(String name) throws IOException {
        FileReader fileReader = new FileReader(name);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        Statement statement = null;
        StringBuilder stringBuilder = new StringBuilder();
        List<Subgraph> subgraphList = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {

            int i = 0;
            while (i < s.length() && s.charAt(i) != '\n') {

                if (s.charAt(i) == '.')
                    break;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                if (s.charAt(i) == ':' && subgraphList.size() == 0)
                    i++;
                if (s.charAt(i) > 'a' && s.charAt(i) < 'z' && statement == null) {
                    StringBuilder statamentString = new StringBuilder();
                    while (s.charAt(i) != ' ') {
                        statamentString.append(s.charAt(i));
                        i++;
                    }
                    statement = Statement.returnStatement(statamentString.toString());
                    continue;
                }

                if (s.charAt(i) == '*') {
                    i++;
                }



                if (s.charAt(i) == '(' && s.charAt(i + 1) != '\'') {
                    int j = subgraphList.size();
                    while (j > 0) {
                        if (!subgraphList.get(j - 1).isEnd()) {
                            stringBuilder.setLength(0);
                            subgraphList.get(j - 1).addNumberForClose();
                            break;
                        }
                        j--;
                    }
                    i++;
                    if (j > 0 && subgraphList.size() > 0)
                        continue;
                    if (s.charAt(i - 1) == '*') {
                        subgraphList.add(new Subgraph(true));
                    } else {
                        subgraphList.add(new Subgraph(false));
                    }
                    continue;
                }

                if (s.charAt(i) == ')' &&  !(i + 1 != s.length() && s.charAt(i + 1) == '\'')) {
                    int j = subgraphList.size();
                    while (true) {
                        if (!subgraphList.get(j - 1).isEnd()) {
                            subgraphList.get(j - 1).reduceNumberForClose();
                            if (stringBuilder.length() != 0 && stringBuilder.charAt(0) != '$')
                                subgraphList.get(j - 1).addLine(new Line(stringBuilder.toString()));
                            else if (stringBuilder.length() != 0 && stringBuilder.charAt(0) == '$')
                                subgraphList.get(j - 1).addLine(new Line(stringBuilder.delete(0, 1).toString()));
                            stringBuilder.setLength(0);
                            break;
                        }
                        j--;
                    }
                    i++;
                    continue;
                }
                Subgraph subgraph;
                if (subgraphList.size() != 0)
                    subgraph = subgraphList.get(subgraphList.size() - 1);
                if (s.charAt(i) == '$') {
                    while (s.charAt(i) != ' ') {
                        i++;
                    }
                    if (stringBuilder.length() == 0)
                        stringBuilder.append('$');
                    continue;
                }

                if (s.charAt(i) == '\'')
                    i++;
                if (i >= s.length())
                    break;
                if (s.charAt(i) == ';' && (s.charAt(i - 1) != '\'')) {
                    int j = subgraphList.size();
                    while (true) {
                        if (!subgraphList.get(j - 1).isEnd()) {
                            if (stringBuilder.length() != 0 && stringBuilder.charAt(0) != '$')
                                subgraphList.get(j - 1).addLine(new Line(stringBuilder.toString()));
                            else if (stringBuilder.length() != 0 && stringBuilder.charAt(0) == '$')
                                subgraphList.get(j - 1).addLine(new Line(stringBuilder.delete(0, 1).toString()));
                            stringBuilder.setLength(0);
                            break;
                        }
                        j--;
                    }
                    i++;
                    continue;
                }
                if (s.charAt(i) == '<' || s.charAt(i) == '>' || s.charAt(i) == ':' || s.charAt(i) == ')' ||
                        s.charAt(i) == '(' || s.charAt(i) == ';' || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                    while (s.charAt(i) == '<' || s.charAt(i) == '>' || s.charAt(i) == ':' || s.charAt(i) == ')' ||
                            s.charAt(i) == ';' || s.charAt(i) == '(' || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                        stringBuilder.append(s.charAt(i));
                        i++;
                        if (i == s.length())
                            break;
                    }
                    stringBuilder.append(' ');
                    i++;
                    continue;
                }




            }
        }

        bufferedReader.close();
        return subgraphList;
    }
}
