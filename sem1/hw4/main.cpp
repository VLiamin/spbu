#include <stdio.h>
#include "head.h"
main()
{
	int number = 0;
	int dead = 0;
	printf("number soldiers: ");
	scanf("%d", &number);
	printf("who dead: ");
	scanf("%d", &dead);
	survive(number, dead);
	return 0;
}
