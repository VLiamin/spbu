#include <stdio.h>
void sort(int left, int right, int *sortArray);

main()
{
	bool isRepeat = false;
	int number = 0;
	printf("length = ");
	int i = 0;
	scanf("%d", &number);
	int *array = new int[number];
	printf("number = ", number);

	for (i = 0; i < number; i++)
		scanf("%d", &array[i]);

	sort(0, number, array);

	for (int i = number - 1; i > 0; i--)
	{
		if (array[i] == array[i - 1])
		{
			printf("max element: %d", array[i]);
			isRepeat = true;
			break;
		}
	}
	
	if (!isRepeat)
	{
		printf("NO");
	}
	delete [] array;
	return 0;
}

void sort(int left, int right, int *sortArray)
{
	int tmp = 0;
	int l = left;
	int r = right;
	int middle = sortArray[left];
	while (right > left)
	{
	    while ((sortArray[right] >= middle) & (right > left))
		{
			right--;	 	
		}	
		while ((sortArray[left] <= middle) & (right > left))
		{
			left++;	
		}
		if 	(right > left)
		{
			tmp = sortArray[right];
			sortArray[right] = sortArray[left];
			sortArray[left] = tmp;
		}
	} 
	tmp = sortArray[left];
	sortArray[left] = middle;
	sortArray[l] = tmp;
	
	middle = left;
	left = l;
	right = r;
	
	if (middle - left > 0)
	{
		sort(left, middle - 1, sortArray);
	}
	if (right - middle > 0)
	{
		sort(middle + 1, right, sortArray);
	}
}
