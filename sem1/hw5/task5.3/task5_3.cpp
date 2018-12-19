#include <stdio.h>
#include "head.h"

char* allocateMemory(char* string, int i);

using namespace std;

main(int argc, char *argv[])
{
	int length = 0;
	printf("Your expression: ");
	int number = 0;
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
	
	
	Stack *stack = createStack();
	i = 0;
	number = 0;
	
	int lengthString = countParentheses(expression);
	
	char *expressionResult = new char[lengthString - 1];
	
	tinkeringFromInfixToPostfix(stack, expression, expressionResult);
	
	
	printf("stringResult: ");
	for (i = 0; i < lengthString; i++)
		printf("%c", expressionResult[i]);
	
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
