#include <stdio.h>
const int lenghtArray = 1000;
main()
{
 	int number = 0;
 	int t = 0;
	printf("number = ");
	scanf("%d", &number);
	int i = 0;
	int min[lenghtArray];
	while (number > 0)
	{
		min[i] = number % 10;
		number = int(number / 10);
		i++;
	}
	for (int j = 0; j < i - 1; j++)
	{
		for (int l = j + 1; l < i; l++)
		{
			if (min[j] > min[l])
			{
				t = min[j];
				min[j] = min[l];
				min[l] = t;
			}
		}
	}
	int j = 0;
	while (min[j] == 0)
	{
		j++;
		if (min[j] != 0)
		{
			t = min[j];
			min[j] = min[0];
			min[0] = t;
			break;
		}
	}
	printf("min number = ");
	for (j = 0; j < i; j++)
	{
		printf("%d", min[j]);
	}
}
