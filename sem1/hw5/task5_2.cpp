#include <stdio.h>
const int stringLength = 100;
const int lengthArray = 27;
main()
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
	if (f != NULL)
	{
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
						array[int(string[i]) - 'A']++;
						i++;
						if (array[int(string[i - 1]) - 'A'] <= 1)
							{
								printf("%c", string[i - 1]);
							}
					}
					else 
					{
						array[int(string[i]) - 'a']++;
						i++;
						if (array[int(string[i - 1]) - 'a'] <= 1)
							{
								printf("%c", string[i - 1]);
							}
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
	}
	return 0;
}
