#include <stdio.h>

void sort(int left, int right, char *str);

int length(char *str);

main()
{
	bool areEqual = true;
	printf("length string: ");
	int lengthString = 0;
	scanf("%d", &lengthString);
	int i = 0;
	printf("first string: ");
	char *str1 = new char[lengthString];
	char *str2 = new char[lengthString];
	scanf("%s", str1);
	printf("second string: ");
	
	scanf("%s", str2);
	int number = length(str1);
	if (number == length(str2))
	{
		sort(0, number - 1, str1);
		sort(0, number - 1, str2);
		for (i = 0; i < number; i++)
		{
			if (str1[i] != str2[i])
			areEqual = false;
		}
		if (areEqual)
			printf("YES");
		else
			printf("NO");
	}
	else
		printf("NO");
	delete [] str1;
	delete [] str2;
	return 0;
}

void sort(int left, int right, char *str)
{
	char tmp = '0';
	int l = left;
	int r = right;
	int middle = str[left];
	while (right > left)
	{
	    while ((str[right] >= middle) & (right > left))
		{
			right--;	 	
		}	
		while ((str[left] <= middle) &  (right > left))
		{
			left++;	
		}
		if 	(right > left)
		{
			tmp = str[right];
			str[right] = str[left];
			str[left] = tmp;
		}
	} 
	tmp = str[left];
	str[left] = middle;
	str[l] = tmp;
	
	middle = left;
	left = l;
	right = r;
	
	if (middle - left > 0)
	{
		sort(left, middle - 1, str);
	}
	if (right - middle > 0)
	{
		sort(middle + 1, right, str);
	}
}

int length(char *str)
{
	int l = 0;
	while (str[l] != '\0')
	{
		l++;
	}
	return l;
}
