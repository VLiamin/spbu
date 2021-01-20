package ru.liamin.vladimir;

import java.util.ArrayList;
import java.util.List;

public class Subgraph {

    private List<Line> lineList;
    private boolean isReturn;
    private List<Subgraph> subgraphs;
    private boolean isEnd;

    public Subgraph(boolean isReturn) {
        this.isReturn = isReturn;
        lineList = new ArrayList<>();
        subgraphs = new ArrayList<>();
    }

    public void addLine(Line line) {
        lineList.add(line);
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public List<Subgraph> getSubgraphs() {
        return subgraphs;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
