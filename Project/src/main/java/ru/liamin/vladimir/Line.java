package ru.liamin.vladimir;

import java.util.List;

public class Line {

    private List<PartOfLine> partOfLines;

    private void addPartOfLines(PartOfLine partOfLine) {
        partOfLines.add(partOfLine);
    }
    public List<PartOfLine> getPartOfLines() {
        return partOfLines;
    }
}
