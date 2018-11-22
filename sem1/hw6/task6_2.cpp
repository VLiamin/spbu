#include <stdio.h>

int countFractional(double digit, int *string, int wholeLength);

int convertToBinary(int digit, int *string);

void convertToDecimal(int *number, int max);

void printBinary(int length, int* string, int j);

void printResult(int length1, int length2, int* addition, int maximum);

main(int argc, char *argv[])
{
	double number1 = 0;
	double number2 = 0;
	printf("First number: ");
	scanf("%lf", &number1);
	printf("Second number: ");
	scanf("%lf", &number2);
	int max = 0;
	int wholePart1 = int(number1 / 1);
	int wholePart2 = int(number2 / 1);
	
	if (wholePart1 > wholePart2)
		max = wholePart1;
	else
		max = wholePart2;
		
	int *string1 = new int[wholePart1 * 4 + 5];
	int *string2 = new int[wholePart2 * 4 + 5];
	int *addition = new int[max * 4 + 5];
	double fraction1 = number1 - wholePart1;
	double fraction2 = number2 - wholePart2;
	int i = 0;
	int length1 = convertToBinary(wholePart1, string1); 
	int length2 = convertToBinary(wholePart2, string2); 
	int lengthFractional1 = countFractional(fraction1, string1, length1);
	int lengthFractional2 = countFractional(fraction2, string2, length2);
	
	printf("First number: ");
	for (i = 0; i < length1 + lengthFractional1; i++)
	{
		printBinary(length1, string1, i);
	}
	
	printf("\n");
	
	printf("Second number: ");
	for (i = 0; i < length2 + lengthFractional2; i++)
	{
		printBinary(length2, string2, i);
	}
	printf("\n");
	if (length1 > length2)
		max = length1;
	else
		max = length2;
	
	int sum1 = 0;
	int sum2 = 0;
	for (i = 0; i < max; i++)
	{
		if (length1 - i > length2)
		{
			addition[i + 1] = string1[i];
			sum2++;
		}
		else if (length2 - i > length1)
		{
			addition[i + 1] = string2[i];
			sum1++;
		}
		else
		{
			addition[i + 1] = string1[i - sum1] + string2[i - sum2];
		}
			
	}
	for (i = 0; i < 5; i++)
	{
		addition[i + max + 1] = string1[i + length1] + string2[i + length2];
	}
	
	addition[0] = 0;
	for (i = max + 5; i > 0; i--)
	{
		if (addition[i] >= 2)
		{
			
			addition[i] -= 2;
			addition[i - 1]++;
		}
	}
	printResult(length1, length2, addition, max);
	convertToDecimal(addition, max);
	delete [] string1;
	delete [] string2;
	delete [] addition;
	return 0;
}

int convertToBinary(int digit, int *string)
{
	int l = 0;
	while (digit != 0)
	{
		string[l] = digit % 2;
		digit = int(digit / 2);
		l++;
	}
	int wholeLength = l;
	for (l = 0; l < int(wholeLength / 2); l++)
	{
		int tmp = string[l];
		string[l] = string[wholeLength - 1 - l];
		string[wholeLength - 1 - l] = tmp;
	}
	return wholeLength;
}

int countFractional(double digit, int *string, int wholeLength)
{
	int l = 0;
	while  (l < 5)
	{
		string[l + wholeLength] = int(digit * 2);
		digit = digit * 2 - int(digit * 2 / 1);
		l++;
	}
	return l;
}

void convertToDecimal(int *number, int max)
{
	double result = 0;
	for (int i = 0; i < max + 6; i++)
	{
		if (i < max)
		{
			for (int j = 0; j < max - i; j++)
			{
				number[i] = number[i] * 2;
			}
			result = result + number[i];
		}
		else if (max == i)
			result = result + number[i];
		else
		{
			double real = number[i];
			for (int j = max; j < i; j++)
			{
				real = real / 2;
			}
			result = result + real;
		}
	}
	printf("\n");
	printf("%lf", result);
}

void printBinary(int length, int* string, int j)
{
	if ((length == 0) && (j == 0))
			printf("0");
		if (j == length)
			printf(",");
		printf("%d", string[j]);
}

void printResult(int length1, int length2, int* addition, int maximum)
{
	for (int i = 0; i < maximum + 6; i++)
	{
		if ((length2 == 0) && (i == 1) && (length1 == 0))
    		printf("0,");
		if ((addition[0] == 0) && (i != 0))
		{
			printf("%d", addition[i]);
			if (i == maximum)
				printf(",");
		}
		else if (addition[0] != 0)
		{
			printf("%d", addition[i]);
			if (i == maximum)
				printf(",");
		}	
	}
}
