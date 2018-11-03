#include <stdio.h>
const int con = 1000;
main()
{
	int n = 0;
	printf("number = ");
	scanf("%d", &n);
	int a[con];
	int i = 0;
	int j = 0;
	for (i = 0; i <= n - 2; i++)
	{
		a[i] = i + 2;
	}
	for (i = 0; i <= n - 2; i++)
	{
	    if (a[i] != 0) 
		{
			for (j = i + 1; j <= n - 2; j++) 
			{
				if ((a[j] % a[i] == 0) & (a[j] != 0))
				{
					a[j] = 0;
				}
			}
		}	
	}
	printf("primes = ");
	for (i = 0; i <= n - 2; i++)
	{
		if (a[i] != 0)
		{
			printf(" %d", a[i]);
		}
	}
	return 0;
}

