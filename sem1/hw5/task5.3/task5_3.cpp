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
	int parentheses = 0;
	
	Stack *stack = createStack();
	i = 0;
	number = 0;
	while (expression[i] != '\n')
	{
		if (expression[i] == '(')
		{
			parentheses++;
		}
		i++;
	}
	int lengthString = i - parentheses * 2;
	char symbol= 'b';
	i = 0;
	parentheses = 0;
	char *expressionResult = new char[lengthString - 1];
   
	while (expression[i] != '\n')
	{
		if (expression[i] == '(')
		{
			parentheses++;
			if (symbol != 'b')
			{
				add(symbol, stack); 
				symbol = 'b';
			}
			i++;
		}
		if (expression[i] == ')')
		{
			parentheses--;
			if (symbol != 'b')
			{
				expressionResult[number] = symbol;
				number++;
			}
			if (plus(stack))
				symbol = pop(stack);
			if (check(stack))
			{
				
				expressionResult[number] = pop(stack);
				number++;
			}
			i++;
		}
		
		if ((int(expression[i]) >= '0') && (int(expression[i]) <= '9'))
		{
			expressionResult[number] = expression[i];
			i++;
			number++;
		}
		
		if ((expression[i] == '*') || (expression[i] == '/'))
		{
			if (expression[i + 1] != '(')
			{
			
				expressionResult[number] = expression[i + 1];
				expressionResult[number + 1] = expression[i];
				number += 2;
				i += 2;
			}
			else
			{
				add(expression[i], stack); 
				i++;
			}
		}
		if ((expression[i] == '-') || (expression[i] == '+'))
		{
			if (symbol != 'b')
			{
				expressionResult[number] = symbol;
				number++;
			}
			symbol = expression[i];	
			i++;
		}
	}
	
	if ((symbol == '-') || (symbol == '+'))
	{
		expressionResult[number] = symbol;
		symbol = 'b';
		number++;
	}
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
