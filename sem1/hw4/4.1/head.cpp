#include <stdio.h>
#include "head.h"

List *createList()
{
	List *tmp = new List;
	return tmp;
}
	
List *add(List *tmp, int number)
{
	tmp->next = new List;
	tmp->next->next = nullptr;
	tmp = tmp->next;
	tmp->number = number + 1;
	return tmp;	 
}
	
List *kill(List *tmp, int i, int dead)
{
	
	List *p = tmp;
	for (int j = 0; j < dead - 2; j++)
	{
		tmp = tmp->next;
	}
	p = tmp->next;
	tmp->next = tmp->next->next;
	tmp = tmp->next;
	delete p;
	return tmp;
}
void print(List *head)	
{
	List *p = head;
	List *element = head;
	printf("Who survived: ");
	printf("%d", element->number);

	element->next = nullptr;
	p = element->next;
	delete element;
	element = p;
	delete head;
	return;
}
