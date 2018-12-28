#include <stdio.h>

char* allocateMemory(char* string, int i);
void sort(char *expression, int left, int right);
void merge(char *expression, int left, int right, int middle);

int main()
{
	printf("Your numbers: ");
	char *expression = new char[10];
	char x = 'b';
	scanf("%c", &x);
	int i = 0;
	expression[i] = x;
	int sum = 0;
	while (expression[i] != '\n')
	{
		i++;
		scanf("%c", &x);
		expression[i] = x;
		if (i % 10 == 8)
		{
			allocateMemory(expression, i + 1);
		}
	}
	int length = i;
	i = 1;
	int middle = 0;
	while (i <= int(length / 2))
	{
		i = i * 2;
		int sum = 0;
		while (sum + i - 1 < length)
		{
			merge(expression, sum, sum + i - 1, sum + int((i - 1) / 2));
			sum = sum + i;
			middle = sum;
		}
		merge(expression, sum, length - 1, sum - 1);
		merge(expression, sum - i, length - 1, sum - 1);
	}
	merge(expression, 0, length - 1, middle - 1);
	printf("Result string: %s", expression);
	delete [] expression;
}


char* allocateMemory(char* string, int i)
{
	char *string2 = new char[i + 10];
	for (int j = 0; j < i; j++)
	{
		string2[j] = string[j];
	}
	delete [] string;
	return string2;
}

void merge(char *expression, int left, int right, int middle)
{
	int i = left;
	int j = middle + 1;
	char *stringMerge = new char [right - left + 4];
	for (int k = left; k <= right; k++) 
	{
		if (i > middle)
		{
			stringMerge[k - left] = expression[j];
			j++;
		} 
		else if (j > right) 
		{
			stringMerge[k - left] = expression[i];
			i++;
		} 
		else if (expression[j] < expression[i]) 
		{
			stringMerge[k - left] = expression[j];
			j++;
		} 
		else 
		{
			stringMerge[k - left] = expression[i];
			i++;
		}
	}    
	i = 0;

	while (i <= right - left)
	{
		expression[left + i] = stringMerge[i];
		i++;
	}
	delete [] stringMerge;
	return;
}
