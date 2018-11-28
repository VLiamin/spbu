#include <stdio.h>
#include "head.h"

char* allocateMemory(char* string, int i);

main(int argc, char *argv[])
{
	int length = 0;
	printf("Your expression: ");
	int number = 0;
	char x = 'b';
	int i = 0;
	char *string = new char[10];
	scanf("%c", &x);
	string[i] = x;
	while (string[i] != '\n')
	{
		i++;
		scanf("%c", &x);
		string[i] = x;
		if (i % 10 == 9)
		{
			allocateMemory(string, i + 1);
		}
	}
	int parentheses = 0;
	
	StackPlus *plus = new StackPlus;
	plus->headPlus = nullptr;
	
	StackMultiplication *multiplication = new StackMultiplication;
	multiplication->headMultiplication = nullptr;
	i = 0;
	number = 0;
	while (string[i] != '\n')
	{
		if (string[i] == '(')
		{
			parentheses++;
		}
		i++;
	}
	int lengthString = i - parentheses * 2;
	char symbol= 'b';
	i = 0;
	parentheses = 0;
	char stringResult[lengthString - 1];
   
	while (string[i] != '\n')
	{
		if (string[i] == '(')
		{
			parentheses++;
			if (symbol != 'b')
			{
				AddPlus(symbol, plus); 
				symbol = 'b';
			}
			i++;
		}
		if (string[i] == ')')
		{
			parentheses--;
			if (symbol != 'b')
			{
				stringResult[number] = symbol;
				number++;
			}
			symbol = PopPlus(plus);
			if (multiplication->headMultiplication != nullptr)
			{
				stringResult[number] = PopMultiplication(multiplication);
				number++;
			}
			i++;
		}
		
		if ((int(string[i]) >= '0') && (int(string[i]) <= '9'))
		{
			stringResult[number] = string[i];
			i++;
			number++;
		}
		if ((string[i] == '*') || (string[i] == '/'))
		{
			if (string[i + 1] != '(')
			{
			
				stringResult[number] = string[i + 1];
				stringResult[number + 1] = string[i];
				number += 2;
				i += 2;
			}
			else
			{
				AddMultiplication(string[i], multiplication); 
				i++;
			}
		}
		if ((string[i] == '-') || (string[i] == '+'))
		{
			if (symbol != 'b')
			{
				stringResult[number] = symbol;
				number++;
			}
			symbol = string[i];	
			i++;
		}
	}
	if ((symbol == '-') || (symbol == '+'))
	{
		stringResult[number] = symbol;
		symbol = 'b';
		number++;
	}
	printf("stringResult: ");
	for (i = 0; i < lengthString; i++)
		printf("%c", stringResult[i]);
	delete [] string;
	delete plus->headPlus;
	delete plus;
	delete multiplication->headMultiplication;
	delete multiplication;
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
