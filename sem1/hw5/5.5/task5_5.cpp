#include <stdio.h>
#include "head.h"

char* allocateMemory(char* string, int i);

using namespace std;

int main(int argc, char *argv[])
{
	char x = 'b';
	printf("Your expression: ");
	int i = 0;
	int meaning = 0;
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
	
	Stack *stack = createStack();
	
	int lengthString = countParentheses(expression);
	
	char *expressionResult = new char[lengthString - 1];
	
	tinkeringFromInfixToPostfix(stack, expression, expressionResult);
	
	count(stack, expressionResult, meaning, lengthString);
	
	printf("Result: %d", meaning);
	delete [] expressionResult;
	delete [] expression;
	deleteStack(stack);
	return 0;
}

char* allocateMemory(char* string, int i)
{
	char *string2 = new char[i + 10];
	for (int j = 0; j < i; j++)
	{
		string2[j] = string[j];
	}
	return string2;
}
