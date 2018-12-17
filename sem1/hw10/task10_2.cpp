#include <stdio.h>

char* allocateMemory(char* string, int i);
char* filing(char* string);

const int multiplier = 256;
const int simple = 31;

int main()
{
	printf("Your string: ");
	char *string = new char[10];
	filing(string);
	printf("Your substring: ");
	char *substring = new char[10];
	filing(substring);
	int i = 0;
	int cashSubstring = 0;
	int cashString = 0;
	
	while (substring[i] != '\n')
	{
		cashSubstring = (multiplier * cashSubstring + substring[i]) % simple;
		cashString = (multiplier * cashString + string[i]) % simple;
		i++;
	}
	
	int length = i;
	int power = 1;
	for (int j = 1; j < length; j++)
		power = (power * multiplier) % simple;
	while (string[i] != '\n')
	{
		bool areEqual = true;
		if (cashSubstring == cashString)
		{
			for (int j = 0; j < length; j++)
			{
				if (substring[j] != string[i - length + j])
					areEqual = false;
			}
			if (areEqual == true)
				printf("The similarity begins from: %d\n", i - length);
		}
		cashString = (multiplier * (cashString + simple - (string[i - length] * power) % simple) + string[i]) % simple;
		i++;
	}
	
	delete [] string;
	delete [] substring;
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

char* filing(char* string)
{
	int i = 0;
	char x = 'b';
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
}
