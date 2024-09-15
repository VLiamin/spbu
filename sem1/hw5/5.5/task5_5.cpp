#include <stdio.h>
#include "calculate.h"

char *allocateMemory(char *string, int i);

using namespace std;

int main(int argc, char *argv[]) {
    char x = 'b';
    printf("Your expression: ");
    int i = 0;
    char *expression = new char[10];
    scanf("%c", &x);
    expression[i] = x;

    while (expression[i] != '\n') {
        i++;
        scanf("%c", &x);
        expression[i] = x;
        if (i % 10 == 9) {
            allocateMemory(expression, i + 1);
        }
    }

    int lengthString = countPostfixLength(expression);

    int meaning = countExpression(expression, lengthString);

    printf("Result: %d", meaning);
    delete[] expression;
    return 0;
}

char *allocateMemory(char *string, int i) {
    char *string2 = new char[i + 10];
    for (int j = 0; j < i; j++) {
        string2[j] = string[j];
    }
    return string2;
}

