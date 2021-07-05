#include <stdio.h>
#include "head.h"

using namespace std;

main()
{
	int choice = 0;
	int number = 0;
	int dead = 0;
	List *list = createList();
	printf("number soldiers: ");
	scanf("%d", &number);
	printf("who dead: ");
	scanf("%d", &dead);
	for (int i = 0; i < number; i++)
	{
		add(list, i);	 	
	}
	
	turnIntoCyclical(list);
	
	for (int i = 1; i <= number - 1; i++)
	{
		pop(list, dead);
	}
	
	print(list);
	pop(list, dead);
	return 0;
}
