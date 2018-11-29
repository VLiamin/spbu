#include <stdio.h>
#include "head.h"

char* allocateMemory(char* string, int i);

int main()
{
	char a = '0';
	char b = '0';
	char x = 'b';
	int meaning = 0;
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
	i = 0;
	Stack *Element = new Stack;
	Element->Head = nullptr;
	while (string[i] != '\n')
	{
		while ((string[i] >= '0') && (string[i] <= '9'))
		{
			add(string[i], Element);
			i++;
		}

		while ((string[i] != '\n') && ((string[i] < '0') || (string[i] > '9')))
		{
			a =  pop(Element); 
			b =  pop(Element);
			a = a - '0';
			b = b - '0';
        
			if (string[i] == '-')
				meaning = b - a;
			else if (string[i] == '+')
				meaning = b + a;
			else if (string[i] == '*')
				meaning = b * a;
			else
				meaning = int(b / a);
        	
        	add(meaning + '0', Element);

			i++;
		}
	}
	
	printf("Result: %d", meaning);
	delete [] string;
	delete Element;
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
