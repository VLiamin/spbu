#include <stdio.h>
const int lengthArray = 100;

void enter(int numeric, int a[lengthArray][lengthArray]);

main()
{
	int number = 0;
	int array[lengthArray][lengthArray];
	printf("Number: ");
	scanf("%d", &number);
	
	enter(number, array);
	
	int cycle = 8;
	int sum = 0;
	int column = int(number / 2);
	int lines = int(number / 2);
	printf("Array output in a spiral: ");
	if (lines == 0)
	{
		printf("0");
	}
	while ((column != 0) && (lines != 0))
	{
		printf(" %d", array[lines][column]);
		column--;
		printf(" %d", array[lines][column]);
		for (int i = 0; i <= 0 + sum * 2; i++)
		{
			lines++;
			printf(" %d", array[lines][column]);
		}
		for (int i = 0; i <= 1 + sum * 2; i++)
		{
			column++;
			printf(" %d", array[lines][column]);
		}
		for (int i = 0; i <= 1 + sum * 2; i++)
		{
			lines--;
			printf(" %d", array[lines][column]);
		}
		for (int i = 0; i <= 1 + sum * 2; i++)
		{
			column--;
			printf(" %d", array[lines][column]);
		}
		sum++;
	}
	return 0;
}

void enter(int numeric, int a[lengthArray][lengthArray])
{
	for (int i = 0; i < numeric; i++)
	{
		for (int j = 0; j < numeric; j++)
		{
			a[j][i] = j + 2 * i;
			printf(" %d", a[j][i]);
		}
		printf("\n");
	}
}
