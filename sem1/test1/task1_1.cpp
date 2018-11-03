#include <stdio.h>
#include <string.h>
#include <iostream> 

int stringlength(char *str);

main()
{
	int length = 0;
	int needLength = 0;
	printf("Need length: ");
	scanf("%d", &needLength);
	char *string = new char[needLength];
	int amount = 0;
	printf("Your string: ");
	scanf(" %[^\n]s", string);
	length = stringlength(string);
	int difference = needLength - length;	
	int i = 0;
	bool isSpace = false;
	
	if (difference != 0)
	{
		while (string[i] != '\0')
		{
			i++;
			if ((string[i] == ' ') && (!isSpace))
			{
				isSpace = true;
				difference--;
				for (int j = length + amount; j > i; j--)
				{
					string[j] = string[j - 1];	
				}
				amount++;
				if (difference == 0)
				{
					break;
				}	
			}
			if (string[i + 1] != ' ')
			{
				isSpace = false;
			}
		}	
	}
	
	if (difference == 0)
	{
		printf("Result: ");
		for (i = 0; i < needLength; i++)
		{
			printf("%c", string[i]);
		}	
	}
	else
	{
		printf("It's impossible");
	}
	
	delete [] string;
	return 0;	
}

int stringlength(char *str)
{
	int l = 0;
	while (str[l] != '\0')
	{
		l++;
	}
	return l;
}
