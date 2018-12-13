#include <stdio.h>
void printPower(int power, int* expression);

void printX(int j, int power);

int main(int argc, char *argv[])
{
	int power = 0; 
	printf("Power: ");
	scanf("%d", &power);
	int *expression = new int[power + 1];
	printf("Your expression: ");
	int i = 0;
	for (i = 0; i <= power; i++)
	{
		scanf("%d", &expression[i]);
	}
	
	printPower(power, expression);
	
	printf("\n");
	
	for (i = 0; i <= power; i++)
	{
		if (expression[i] != 0)
		{
			if ((expression[i] > 0) || (i == 0))
			{
				if (i != 0)
					printf("+ ");
				if ((expression[i] != 1) && (expression[i] != -1))
					printf("%d", expression[i]);	
				if ((expression[i] == -1) && (i == 0))
					printf("-");
						
				printX(i, power);
				
			}
			else
			{
				printf("- ");
				printf("%d", expression[i] * (-1));
				
				printX(i, power);
				
			}	
		}
	}
	
	delete [] expression;
	return 0;
}

void printPower(int power, int* expression)
{
	for (int j = 0; j < power - 1; j++)
	{
		int replacement = expression[j];
		if (replacement != 0)
		{
			if ((expression[0] < 0) && (j == 0))
				printf(" ");
			while ((replacement != 0) && (expression[j] != 1) && (expression[j] != -1))
			{
				printf(" ");
				replacement = int(replacement / 10);
			}
			printf(" ");
			printf("%d", power - j);
			printf("  ");
		}
	}	
}

void printX(int j, int power)
{
	int substitute = power - j;
	if (j != power)
	{
		printf("x");
		while (substitute != 0)
		{
			printf(" ");
			substitute = substitute / 10;
		}
	}
}
