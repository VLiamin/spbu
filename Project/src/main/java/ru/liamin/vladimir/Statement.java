package ru.liamin.vladimir;

public class Statement {
    private String statement;
    private static Statement statementClass;

    private Statement(String statement) {
        this.statement = statement;
    }

    public static Statement returnStatement(String word) {
        if (statementClass == null) {
            statementClass = new Statement(word);
            return statementClass;
        }
        return statementClass;
    }

    public String getStatement() {
        return statement;
    }
}
