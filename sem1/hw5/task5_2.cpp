#include <stdio.h>
const int stringLength = 100;
const int lengthArray = 27;

void pullOut(int &j, int *number, char *symbol, char letter);

main(int argc, char *argv[])
{
	char string[stringLength];
	int number = 0;
	int i = 0;
	int array[lengthArray];
	for (i = 0; i < lengthArray; i++)
	{
		array[i] = 0;
	}
	FILE *f  = fopen("text3.txt", "r");
	if (f == nullptr)
		return 0;
		
	while (fgets(string, stringLength, f))
	{
		i = 0;
		for (int j = 0; j < lengthArray; j++)
		{
			array[j] = 0;
		}
		while (string[i] != '\0')
		{
			if (((int(string[i]) <= 'z') && (int(string[i]) >= 'a')) || ((int(string[i]) <= 'Z') && (int(string[i]) >= 'A')))
			{
				if (int(string[i]) < 'a')
				{
					pullOut(i, array, string, 'A');
				}
				else 
				{
					pullOut(i, array, string, 'a');
				}
			}
			else
			{
				i++;
				for (int j = 0; j < lengthArray; j++)
				{
					array[j] = 0;
				}
				printf(" ");
			}
		}
		printf("\n");
	}
	
	return 0;
}

 void pullOut(int &j, int *number, char *symbol, char letter)
 {
	number[symbol[j] - letter]++;
	j++;
	if (number[symbol[j - 1] - letter] <= 1)
	{
		printf("%c", symbol[j - 1]);
	}
 }
