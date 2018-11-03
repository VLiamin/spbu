#include <stdio.h>
main()
{
	printf("a = ");
	int a;	
	scanf("%d", &a);
	printf("b = ");
	int b; 
	scanf("%d", &b);
	int sum = 0;
	while (a > 0) 
	{
		if (a - b >= 0) 
		{
			sum++;
		}
		a = a - b;
	}
	printf("the partial quotient = %d", sum);
	return 0;
}
