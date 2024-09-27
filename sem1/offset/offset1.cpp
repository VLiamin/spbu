#include <stdio.h>

int* allocateMemory(int* string, int i);
void sort(int left, int right, int *array);

int main(int argc, char *argv[])
{
	int sum = 0;
	int i = 0;
	int x = 0;
	int *numbers = new int[10];
	printf("Your numbers: ");
	while (numbers[i] != 0)
	{
		i++;
		scanf("%d", &x);
		numbers[i] = x;
		
		if (i % 10 == 9)
		{
			allocateMemory(numbers, i + 1);
		}
	}
	sort(0, i, numbers);
	printf("     RESULT\n");
	for (int j = 1; j < i; j++)
	{
		if (numbers[j] != numbers[j - 1])
		{
			if (j != 1) 
				printf(" - %d time\n", sum);
			sum = 1;
			printf("number %d", numbers[j]);	
		}	
		else
			sum++;
		if (j == i - 1) 
			printf(" - %d time\n", sum);
			
	}
	delete [] numbers;
	return 0;
}

int* allocateMemory(int* string, int i)
{
	int *string2 = new int[i + 10];
	for (int j = 0; j < i; j++)
	{
		string2[j] = string[j];
	}
	return string2;
}

void sort(int left, int right, int *array)
{
	int tmp = 0;
	int l = left;
	int r = right;
	int middle = array[left];
	while (right > left)
	{
	    while ((array[right] >= middle) & (right > left))
		{
			right--;	 	
		}	
		while ((array[left] <= middle) &  (right > left))
		{
			left++;	
		}
		if 	(right > left)
		{
			tmp = array[right];
			array[right] = array[left];
			array[left] = tmp;
		}
	} 
	tmp = array[left];
	array[left] = middle;
	array[l] = tmp;
	
	middle = left;
	left = l;
	right = r;
	
	if (middle - left > 0)
	{
		sort(left, middle - 1, array);
	}
	if (right - middle > 0)
	{
		sort(middle + 1, right, array);
	}
}
