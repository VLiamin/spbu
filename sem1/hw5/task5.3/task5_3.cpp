#include <stdio.h>
#include "head.h"
#include "calculate.h"

char* allocateMemory(char* str, int i);

using namespace std;

int main(int argc, char *argv[])
{
    int length = 0;
    printf("Your expression: ");
    char x = 'b';
    int i = 0;
    char *expression = new char[10];
    scanf("%c", &x);
    expression[i] = x;

    while (expression[i] != '\n')
    {
        i++;
        scanf("%c", &x);
        expression[i] = x;
        if (i % 10 == 9)
        {
            allocateMemory(expression, i + 1);
        }
    }

    length = countPostfixLength(expression);

    char* expressionResult = tinkeringFromInfixToPostfix(expression, length);

    printf("stringResult: ");
    print(expressionResult, length);

    delete [] expressionResult;
    delete [] expression;
    return 0;
}

char* allocateMemory(char* str, int i)
{
    char *string2 = new char[i + 10];
    for (int j = 0; j < i; j++)
    {
        string2[j] = str[j];
    }
    return string2;
}
