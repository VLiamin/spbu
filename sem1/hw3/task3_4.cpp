#include <stdio.h>
#include <stdlib.h>

int countBull(int *computerA, int *youA);

int countCow(int *computerA, int *youA);

const int lengthArray = 4;
main()
{
	int bulls = 0;
	int cows = 0;
	int personA[lengthArray];
	int l = 0;
	int array[lengthArray];
	int i = 0;
	int number = 0;
	for (i = 0; i < lengthArray; i++)
	{
		array[i] = int(rand() % 2) + i*2;
	}
	
	for (int j = 0; j < 8; j++)
	{
		printf("your number = ");
		scanf("%d", &number);
		for (i = lengthArray - 1; i >= 0; i--)
		{
			personA[i] = number % 10;
			number = int(number / 10);
		}
        
		bulls = countBull(array, personA);
        
		cows = countCow(array, personA); 
		
		if (bulls == 4)
		{
			printf("You win!");
			break;
		}
		else
		{
			if (j == 7)
			{
				printf("My number: ");
				for (i = 0; i < 4; i++)
				{
					printf("%d", array[i]);
				}
				printf("\n");
				printf("I win!\n");
				break;
			}
		}
		printf("bulls = %d\n", bulls);
		printf("cows = %d\n", cows);
	}
	return 0;
}

int countBull(int *computerA, int *youA)
{
	int bull = 0;
	for (int l = 0; l < lengthArray; l++)
		{
			if (computerA[l] == youA[l])
			{
				bull++;	
				youA[l] = -8;
			}
		}
	return bull; 
}

int countCow(int *computerA, int *youA)
{
	int cow = 0;
	for (int i = 0; i < lengthArray; i++)
		{
			for (int l = 0; l < lengthArray; l++)
			{
				if (computerA[i] == youA[l])
				{
					cow++;
				}
			}
		}
	return cow;
}
