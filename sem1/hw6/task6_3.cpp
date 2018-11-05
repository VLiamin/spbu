#include <stdio.h>
main()
{
	int power = 0; 
	printf("Power: ");
	scanf("%d", &power);
	int *expression = new int(power);
	printf("Your expression: ");
	int i = 0;
	for (i = 0; i <= power; i++)
	{
		scanf("%d", &expression[i]);
	}
	for (i = 0; i < power; i++)
	{
		int substitute = expression[i];
		if (substitute != 0)
		{
			if ((expression[0] < 0) && (i == 0))
				printf(" ");
			while ((substitute != 0) && (expression[i] != 1))
			{
				printf(" ");
				substitute = int(substitute / 10);
			}
			printf(" ");
			printf("%d", power - i);
			printf("  ");
		}
	}
	printf("\n");
	for (i = 0; i <= power; i++)
	{
		int substitute = power - i;
		if (expression[i] != 0)
		{
			if ((expression[i] > 0) || (i == 0))
			{
				if (i != 0)
					printf("+ ");
				if (expression[i] != 1)
					printf("%d", expression[i]);
				if (i != power)
				{
					printf("x");
					while (substitute != 0)
					{
						printf(" ");
						substitute = substitute / 10;
					}
				}
			}
			else
			{
				printf("- ");
				if (expression[i] * (-1) != 1)
					printf("%d", expression[i] * (-1));
				if (i != power)
				{
					printf("x");
					while (substitute != 0)
					{
						printf(" ");
						substitute = substitute / 10;
					}
				}
			}
			
		}
	}
	delete [] expression;
	return 0;
}
