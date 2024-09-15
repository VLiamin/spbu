#include <stdio.h>
const int lengthArray = 1000;

bool gcd(int a, int b);

void printFraction(int *numerator, int length);

int main(int argc, char *argv[])
{
	int n = 0;
	printf("number = ");
	scanf("%d", &n);
	int array[lengthArray];
	int i = 0;
	for (i = 0; i < lengthArray; i++)
	{
		array[i] = lengthArray * 10000;
	}
	int l = 0;
	int j = 0;
	int number = 1;
	for (l = 2; l <= n; l++)
		number *= l;
	int substitute = 0;
	int num = -1;	
	
	for (int i = 2; i <= n; i++)
	{
		for (j = 1; j < i; j++)
		{
			substitute = number;
			if (gcd(i, j))
			{	
				num++;
				array[num] = int(substitute / i) * j;	
			}
		}
	}

	int t = 0;
	
	for (i = 0; i <= num - 1; i++)
	{
		for (j = i + 1; j <= num; j++)
		{
			if (array[i] > array[j])
			{
				t = array[i];
				array[i] = array[j];
				array[j] = t;
			}
		}
	}

	printFraction(array, n);
	
	return 0;
}
 bool gcd(int a, int b)
{
	bool iscommonFactor = false;
	for (int l = 2; l < a; l++)
	{
		if ((a % l == 0) & (b % l == 0))
		{
			iscommonFactor = true;	
		}
	}
	return (iscommonFactor == false);
}

void printFraction(int *numerator, int length)
{
	int i = 0;
	
	int denominator = 0;
 	while (numerator[i] < lengthArray * 10000)
	{
		int substitute = numerator[i];
		int num = 0;
		for (int j = length; j > 1; j--)
		{
			if (numerator[i] % j == 0)
				numerator[i] = int(numerator[i] / j);
			else
			{	
				denominator = j;
				num++;
			}
		}
		if (num > 1)
		{
			numerator[i] = substitute;
			for (int j = 2; j < length + 1; j++)
			{
				if (numerator[i] % j == 0)
					numerator[i] = int(numerator[i] / j);
				else	
					denominator = j;	
			}	
		}
		printf("%d", numerator[i]);
		printf(" / ");
		printf("%d\n", denominator);
		i++;
	}
}
