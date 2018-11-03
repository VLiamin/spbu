#include <stdio.h>
#include <stdlib.h>
const int lenghtArray = 1000;
void sort(int right, int left, int *array);
main()
{
	int n;
	printf("number = ");
	scanf("%d", &n);
	int a[lenghtArray];
	int i = 0;
	int sum =  0;
	printf("Array:");
	for (i = 0; i < n; i++)
	{
		a[i] = rand() % 15;	
		printf(" %d", a[i]);
	}
	printf("\n");
	sort(0, n - 1, a);
	printf("New array:");
	for (i = 0; i < n; i++)
	{
		printf(" %d", a[i]);	
	}
	return 0;
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
