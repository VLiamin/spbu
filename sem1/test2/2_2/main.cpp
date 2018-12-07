#include <stdio.h>
#include "head.h"

using namespace std;
 
int main()
{
	List *list = createList();
	int number = 0;
	printf("Number: ");
	scanf("%d", &number);
	int i = 0;
	int j = 0;
	int x = 0;
	printf("YourElements: ");
	
	for (i = 0; i < number; i++)
	{
		scanf("%d", &x);
		push(list, x);
	}
	for(i = 1; i < number; i++)
	{
		int value = returnList(list, i);
		for (j = i; ((j > 0) && (value < returnList(list, j - 1))); j--)
		{
				x = pop(list, j);
				insert(list, x, j - 1);
		}
	}
	for (i = 0; i < number; i++)
	{
		printf(" %d", print(list));
	}
}
