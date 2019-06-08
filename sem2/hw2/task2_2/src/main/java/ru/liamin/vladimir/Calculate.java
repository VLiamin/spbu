package ru.liamin.vladimir;

/** Considers expression */
public class Calculate {
    private int i;
    private Stack stack;
    private int number;
    private char symbol = 'b';

    public Calculate(Stack stack) {

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
                if (temp != 'b') {
                    expressionResult[number] = temp;
                    number++;
                }
            }
            i++;
        }
    }

    private void changeNumbersWithArithmeticSigns(char[] expression, char[] expressionResult) {

        if (i == expression.length)
            return;
        if ((expression[i] >= '0') && (expression[i]) <= '9') {
            expressionResult[number] = expression[i];
            i++;
            number++;
            if (i == expression.length)
                return;
        }
        if ((expression[i] == '*') || (expression[i] == '/')) {
            if (expression[i + 1] != '(') {

                expressionResult[number] = expression[i + 1];
                expressionResult[number + 1] = expression[i];
                number += 2;
                i += 2;
                if (i == expression.length)
                    return;
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
        int length = countPostfixLength(expression);
        char[] expressionResult = new char[length];

        while (i < expression.length) {
            seeParentheses(expression, expressionResult);
            changeNumbersWithArithmeticSigns(expression, expressionResult);
        }

        if ((symbol == '-') || (symbol == '+')) {
            expressionResult[number] = symbol;
            symbol = 'b';
            number++;
        }
        return expressionResult;

    }

    private int countPostfixLength(char[] expression) {
        int parentheses = 0;
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
    public int calculate(char[] expression) {

        int variable1 = 0;
        int variable2 = 0;
        int result = 0;
        expression = tinkeringFromInfixToPostfix(expression);
        int i = 0;
        while (i < expression.length) {
            while ((expression[i] >= '0') && (expression[i] <= '9')) {
                stack.push(expression[i]);
                i++;
            }
            while ((i < expression.length) && ((expression[i] < '0') || (expression[i] > '9'))) {

                variable1 = stack.pop() - '0';
                variable2 = stack.pop() - '0';
                if (expression[i] == '-')
                    result = variable2 - variable1;
                else if (expression[i] == '+')
                    result = variable2 + variable1;
                else if (expression[i] == '*')
                    result = variable2 * variable1;
                else
                    result = variable2 / variable1;

                stack.push((char) (result + '0'));

                i++;
            }
        }

        stack.clear();

        return result;
    }
}
