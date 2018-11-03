#include <stdio.h>

main()
{
	int x = 0;
	printf("x = ");
	scanf("%d", &x);
	int x2 = x * x;
	int solution = (x2 + 1) * (x2 + x) + 1;
	printf("solution = %d", solution);
	return 0;
}
