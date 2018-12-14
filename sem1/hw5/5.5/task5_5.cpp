#include <stdio.h>
#include "head.h"

char* allocateMemory(char* string, int i);

using namespace std;

int main(int argc, char *argv[])
{
	char a = '0';
	char b = '0';
	char x = 'b';
	int meaning = 0;
	int length = 0;
	printf("Your expression: ");
	int number = 0;
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
				symbol = 'b';
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
	i = 0;
	printf("%s\n", expressionResult);
	while (expressionResult[i] != '\0')
	{
		while ((expressionResult[i] >= '0') && (expressionResult[i] <= '9'))
		{
			add(expressionResult[i], stack);
			i++;
		}

		while ((expressionResult[i] != '\0') && ((expressionResult[i] < '0') || (expressionResult[i] > '9')))
		{
			a =  pop(stack); 
			b =  pop(stack);
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
