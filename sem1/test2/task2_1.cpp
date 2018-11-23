#include <stdio.h>

const int lengthArray = 3;

main(int argc, char *argv[])
{
	printf("Number: ");
	int i = 0;
	scanf("%d", &i);
	int fibonacci[lengthArray];
	fibonacci[0] = 1;
	fibonacci[1] = 1;
	if (i <= 2)
	{
		printf("1");
	}
	while (i > 2)
	{
		fibonacci[2] = fibonacci[1] + fibonacci[0]; 
		for (int j = 0; j < 2; j++)
		{
			fibonacci[j] = fibonacci[j + 1];
		}
		i--;
	}
	printf("Your element: %d", fibonacci[2]);
	return 0;
}
