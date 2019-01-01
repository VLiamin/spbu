#include "calculate.h"
#include <stdio.h>

void seeParentheses(Stack *stack, char *expression, int &i, char &symbol, int &parentheses, char *expressionResult,
                    int &number) {
    if (expression[i] == '(') {
        parentheses++;
        if (symbol != 'b') {
            add(symbol, stack);
            symbol = 'b';
        }
        i++;

    }
    if (expression[i] == ')') {
        parentheses--;
        if (symbol != 'b') {
            expressionResult[number] = symbol;
            number++;
            symbol = 'b';
        }

        if (isPlusOrMinus(stack)) {
            symbol = pop(stack);
            i++;
            return;
        }

        if (isNotEmpty(stack)) {
            expressionResult[number] = pop(stack);
            number++;
        }
        i++;
    }
}

void swapSymbols(Stack *stack, char *expression, int &i, char &symbol, int &parentheses, char *expressionResult,
                 int &number) {
    if ((int(expression[i]) >= '0') && (int(expression[i]) <= '9')) {
        expressionResult[number] = expression[i];
        i++;
        number++;
    }

    if ((expression[i] == '*') || (expression[i] == '/')) {
        if (expression[i + 1] != '(') {

            expressionResult[number] = expression[i + 1];
            expressionResult[number + 1] = expression[i];
            number += 2;
            i += 2;
        } else {
            add(expression[i], stack);
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

char *tinkeringFromInfixToPostfix(Stack *stack, char *expression, int length) {
    int i = 0;
    int number = 0;
    int parentheses = 0;
    char symbol = 'b';

    char *expressionResult = new char[length];

    while (expression[i] != '\n') {
        seeParentheses(stack, expression, i, symbol, parentheses, expressionResult, number);

        swapSymbols(stack, expression, i, symbol, parentheses, expressionResult, number);

    }
    if ((symbol == '-') || (symbol == '+')) {
        expressionResult[number] = symbol;
        symbol = 'b';
        number++;
    }
    expressionResult[number] = '\n';
    return expressionResult;

}

int countPostfixLength(char *expression) {
    int parentheses = 0;
    int i = 0;
    while (expression[i] != '\n') {
        if (expression[i] == '(') {
            parentheses++;
        }
        i++;
    }
    int lengthString = i - parentheses * 2;
    return lengthString;
}

int countExpression(char *string, int length) {

    Stack *stack = createStack();
    char *expressionResult = tinkeringFromInfixToPostfix(stack, string, length);
    int meaning = 0;
    int i = 0;
    char a = '0';
    char b = '0';

    while (expressionResult[i] != '\n') {
        while ((expressionResult[i] >= '0') && (expressionResult[i] <= '9')) {
            add(expressionResult[i], stack);
            i++;
        }

        while ((expressionResult[i] != '\n') && ((expressionResult[i] < '0') || (expressionResult[i] > '9'))) {
            a = pop(stack);
            b = pop(stack);
            a = a - '0';
            b = b - '0';

            if (expressionResult[i] == '-')
                meaning = b - a;
            else if (expressionResult[i] == '+')
                meaning = b + a;
            else if (expressionResult[i] == '*')
                meaning = b * a;
            else
                meaning = int(b / a);

            add(meaning + '0', stack);

            i++;
        }
    }

    deleteStack(stack);

    return meaning;
}

