#include <stdio.h>
main()
{
	int n = 0;
	printf("number = ");
	scanf("%d", &n);
	int power = 0;
	printf("power = ");
	scanf("%d", &power);
	int exp = 1;
	for (int i = power; i > 0; i--)
	{
		exp = exp * n;
		
	}
	printf("exponentiating = %d", exp);
	return 0;
}

