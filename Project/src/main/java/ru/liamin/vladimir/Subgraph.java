package ru.liamin.vladimir;

import java.util.ArrayList;
import java.util.List;

public class Subgraph {

    private List<Line> lineList;
    private boolean isReturn;
    private boolean isEnd;
    private int numberForClose;

    public Subgraph(boolean isReturn) {
        this.isReturn = isReturn;
        lineList = new ArrayList<>();
        isEnd = false;
        numberForClose = 1;
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

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public int getNumberForClose() {
        return numberForClose;
    }

    public void addNumberForClose() {
        numberForClose++;
    }
    public void reduceNumberForClose() {
        numberForClose--;
        if (numberForClose == 0)
            isEnd = true;
    }
}
