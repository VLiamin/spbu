package ru.liamin.vladimir;

/** Considers expression */
public class Calculate {
    private int meaning;
    private int i;
    private char a;
    private char b;
    private int variable1;
    private int variable2;
    private Stack stack;
    private int number;
    private char symbol = 'b';
    private int parentheses = 0;

    public Calculate(Stack stack){
        this.stack = stack;
    }

    private void seeParentheses(char[] expression, char[] expressionResult) {
        if (expression[i] == '(') {
            if (symbol != 'b') {
                stack.push(symbol);
                symbol = 'b';
            }
            if ((i != 0) && (expression[i - 1] == '('))
                stack.push('b');
            i++;

        }
        if (expression[i] == ')') {
            if (symbol != 'b') {
                expressionResult[number] = symbol;
                number++;
                symbol = 'b';
            }

            if (stack.isPlusOrMinus()) {
                symbol = stack.pop();
                i++;
                return;
            }

            if (!stack.isEmpty()) {
                char temp = stack.pop();
                if (temp != 'b')
                {
                    expressionResult[number] = temp;
                    number++;
                }
            }
            i++;
        }
    }

    private void swapSymbols(char[] expression, char[] expressionResult) {

        if (i == expression.length) return;
        if ((expression[i] >= '0') && (expression[i]) <= '9') {
            expressionResult[number] = expression[i];
            i++;
            number++;
            if (i == expression.length) return;
        }
        if ((expression[i] == '*') || (expression[i] == '/')) {
            if (expression[i + 1] != '(') {

                expressionResult[number] = expression[i + 1];
                expressionResult[number + 1] = expression[i];
                number += 2;
                i += 2;
                if (i == expression.length) return;
            } else {
                stack.push(expression[i]);
                i++;
            }
        }
        if ((expression[i] == '-') || (expression[i] == '+')) {
            if (symbol != 'b') {
                expressionResult[number] = symbol;
                number++;
            }
            symbol = expression[i];
            i++;
        }
    }

    private char[] tinkeringFromInfixToPostfix(char[] expression) {
        i = 0;
        parentheses = 0;
        int length = countPostfixLength(expression);
        char[] expressionResult = new char[length];

        while (i < expression.length) {
            seeParentheses(expression, expressionResult);
            swapSymbols(expression, expressionResult);
        }

        if ((symbol == '-') || (symbol == '+')) {
            expressionResult[number] = symbol;
            symbol = 'b';
            number++;
        }
        return expressionResult;

    }

    private int countPostfixLength(char[] expression) {
        parentheses = 0;
        int i = 0;
        while (i < expression.length) {
            if (expression[i] == '(') {
                parentheses++;
            }
            i++;
        }
        int lengthString = i - parentheses * 2;
        return lengthString;
    }

    /**
     * Considers our expression
     * @param expression infix expression
     * @return expression value
     */
    public int countExpression(char[] expression){

        expression =  tinkeringFromInfixToPostfix(expression);
        i = 0;
        while (i < expression.length) {
            while ((expression[i] >= '0') && (expression[i] <= '9')) {
                stack.push(expression[i]);
                i++;
            }
            while ((i < expression.length) && ((expression[i] < '0') || (expression[i] > '9'))) {
                a = stack.pop();
                b = stack.pop();
                variable1 = a - '0';
                variable2 = b - '0';
                if (expression[i] == '-')
                    meaning = variable2 -  variable1;
                else if (expression[i] == '+')
                    meaning = variable2 + variable1;
                else if (expression[i] == '*')
                    meaning = variable2 * variable1;
                else
                    meaning = variable2 / variable1;

                a = (char)(meaning + '0');
                stack.push(a);

                i++;
            }
        }

        stack.clear();

        return meaning;
    }
}
