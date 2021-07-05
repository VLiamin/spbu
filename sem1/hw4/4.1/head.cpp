#include <stdio.h>
#include "head.h"


List *createList()
{
    return new List {nullptr};
}
	
void add(ListElement *&tmp, int number)
{
	if (tmp == nullptr)
	{
		tmp = new ListElement;
		tmp->next= nullptr;
		tmp = tmp;
		tmp->number = number + 1; 
		return;		
	}
	else
	{
		add(tmp->next, number);	
	}
	return;	 
}


void add(List *&list, int number)
{
	add(list->head, number);
}
	
void turnIntoCyclical(ListElement *&tmp)
{
	ListElement *p = tmp;
	while (p->next)
	{
		p =p->next;
	}
	p->next = tmp;
	return;
}

void turnIntoCyclical(List *list)
{
	turnIntoCyclical(list->head);
}

void pop(ListElement *&tmp, int dead)
{
	ListElement *p = tmp;
	for (int j = 0; j < dead - 2; j++)
	{
		tmp = tmp->next;
	}
	p = tmp->next;
	tmp->next = tmp->next->next;
	tmp = tmp->next;
	delete p;
	return;
}

void pop(List *list, int dead)
{
	pop(list->head, dead);
	if (list->head == nullptr)
		delete list;
}

void print(ListElement *tmp)	
{
	printf("Who survived: ");
	printf("%d", tmp->number);
	return;
}

void print(List *list)
{
	print(list->head);
}
