#include <stdio.h>
#include "head.h"
main()
{
	int number = 0;
	int dead = 0;
	List *tmp = createList();
	List *head = tmp;
	printf("number soldiers: ");
	scanf("%d", &number);
	printf("who dead: ");
	scanf("%d", &dead);
	for (int i = 0; i < number; i++)
	{
		tmp = add(tmp, i);
		if (i == 0)
			head = tmp;	 	
	}
	tmp->next = head;
	tmp = tmp->next;
	for (int i = 0; i < number - 1; i++)
	{
		//printf("%d", tmp->number);	
		tmp = kill(tmp, i, dead);
	}
	print(tmp);
	return 0;
}
