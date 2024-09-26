#include <stdio.h>
#include "list.h"

using namespace std;

int main()
{
	int i = 0;
	int value = 0;
	int priority = 0;
	List *list = createList();
	printf("0 - ext\n");
	printf("1 - input\n");
	printf("2 - output\n");
	bool isExit = false;
	while (!isExit) 
	{
		printf("Your number: ");
		scanf("%d", &i);
		switch (i) 
		{
			case 0:
				isExit = true;
				break;
			case 1:
				printf("Your value: ");	
				scanf("%d", &value);
				printf("Priority: ");
				scanf("%d", &priority);
				enqueue(list, value, priority);
				break;
			case 2:
				printf("value: %d\n", dequeue(list));
				break;
		}
	}
	deleteList(list);
	return 0;
}
