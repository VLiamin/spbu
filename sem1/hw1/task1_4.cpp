#include <stdio.h>
main()
{
	int a[28];
	int sum = 0;
	for (int i = 0; i < 28; i++)
	{
		a[i] = 0;
	}
	for (int i = 0; i <= 9; i++) 
	{
	     for (int j = 0; j <= 9; j++)
		 {
		 	for (int l = 0; l <= 9; l++)
		 	{
		 		a[l + j + i]++;
			 }
		 }	
	}
	for (int i = 0; i < 28; i++)
	{
		sum = sum + a[i] * a[i];
	}
	printf("number = %d", sum);
	return 0;
}

