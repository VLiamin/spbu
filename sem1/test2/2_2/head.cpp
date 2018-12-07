#include <stdio.h>
#include "head.h"

List *createList()
{
    return new List {nullptr};
}

void push(ListElement *&tmp, int number)
{
	if (tmp == nullptr)
	{
		tmp = new ListElement;
		tmp->next= nullptr;
		tmp = tmp;
		tmp->value = number; 
		return;		
	}
	else
	{
		push(tmp->next, number);	
	}
	return;	 
}


void push(List *&list, int number)
{
	push(list->head, number);
}

int returnList(ListElement *tmp, int number)
{
	for (int i = 0; i < number; i++)
	{
		tmp = tmp->next;
	}
	printf("re %d", tmp->value);
	return tmp->value;
}
int returnList(List *list, int number)
{
	return returnList(list->head, number);
}

int pop(ListElement *&tmp, int number)
{
	ListElement *p = tmp;
	for (int j = 0; j < number - 2; j++)
	{
		tmp = tmp->next;
	}
	p = tmp->next;
	int x = p->value;
	tmp->next = tmp->next->next;
	tmp = tmp->next;
	delete p;
	return x;
}

int pop(List *list, int number)
{
	return pop(list->head, number);
}

int print(ListElement *&tmp)
{
	int x = tmp->value;
	tmp = tmp->next;
	return x;
}

int print(List *list)
{
	return print(list->head);
}

void insert(ListElement *&tmp, int x, int j)
{
	for (int i = 0; i < j - 1; i++)
	{
		tmp = tmp->next;
	}
		ListElement *p = new ListElement;
		if (j != 0)
		{
			p->next= tmp->next;
		
			tmp->next = p;
		}
		else
			p->next= tmp;
		p->value = x;
		
		printf("in %d", p->next->value);
}

void insert(List *&list, int x, int j)
{
	insert(list->head, x, j);
}
