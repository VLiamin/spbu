#include <stdio.h>
const int numerator = 1000;
bool gcb(int a, int b);
main()
{
	int n = 0;
	printf("number = ");
	scanf("%d", &n);
	int array[numerator];
	int i = 0;
	for (i = 0; i < numerator; i++)
	{
		array[i] = 1000000;
	}
	int l = 0;
	int j = 0;
	int number = 1;
	for (l = 2; l <= n; l++)
		number *= l;
	int materic = 0;
	int num = -1;	
	
	for (int i = 2; i <= n; i++)
	{
		for (j = 1; j < i; j++)
		{
			materic = number;
			if (gcb(i, j) == true)
			{	
				num++;
				array[num] = int(materic / i) * j;	
			}
		}
	}
	
	int t = 0;
	
	for (i = 0; i < numerator - 1; i++)
	{
		for (j = i + 1; j < numerator; j++)
		{
			if (array[i] > array[j])
			{
				t = array[i];
				array[i] = array[j];
				array[j] = t;
			}
		}
	}
	
	i = 0;
	
	int denominator = 0;
 	while (array[i] < 1000000)
	{
		for (j = n; j > 1; j--)
		{
			if (array[i] % j == 0)
			{
				array[i] = int(array[i] / j);
			}
			else
			{	
				denominator = j;
			}			
		}
		printf("%d", array[i]);
		printf(" / ");
		printf("%d\n", denominator);
		i++;
	}
	return 0;
}
 bool gcb(int a, int b)
{
	int f = 1;
	for (int l = 2; l < a; l++)
	{
		if ((a % l == 0) & (b % l == 0))
		{
		   f = 0;	
		}
	}
	return (f == 1);
}
