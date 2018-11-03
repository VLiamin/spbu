#include <stdio.h>
main()
{
	int n = 0;
	int pow = 0;
	printf("number = ");
	scanf("%d", &n);
	printf("power = ");
	scanf("%d", &pow);
	int x = n;
	for (int i = 1; i <= int(pow / 2); i++)
	{
		x = x * x;
	}
	if (pow % 2 == 1)
		x *= n; 
	printf("result = %d", x);
	return 0;
}
