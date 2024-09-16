#include <stdio.h>
const int lengthArray = 10000;
main()
{
	printf("number = ");
	int number = 0;
	scanf("%d", &number);
	int sum = 0;
	int terms[lengthArray];
	int j = 0;
	for (int i = 0; i < number; i++)
	{
		terms[i] = 1;
	}
	bool isEquality = true;
	while (terms[0] <= number)
	{
		isEquality = true;
		sum = terms[0];
		printf("%d", terms[0]);
		j = 0;
		while (sum < number)
		{
			j++;
			sum = sum + terms[j];
			printf(" %d", terms[j]);
		}
		for (int i = 0; i < j - 1; i++)
		{
			if (terms[i] > terms[i + 1] )
			{
				terms[i + 1]++;
				isEquality = false;
				break;
			}
		}
			if (isEquality)
			{
				terms[0]++;
				for (int i = 1; i < number; i++)
				{
					terms[i] = 1;
				}
			}	
		printf("\n");
	}
}
