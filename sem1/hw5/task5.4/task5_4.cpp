#include <stdio.h>
#include "calculate.h"

using namespace std;

char* allocateMemory(char* string, int i);

int main()
{
	char x = 'b';
	int i = 0;
	printf("Your expression: ");
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
	
	int meaning = countExpression(string);	
	
	printf("Result: %d", meaning);
	delete [] string;
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

