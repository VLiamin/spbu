#include <stdio.h>
#include "list.h"

List *createList()
{
    return new List {nullptr};
}

void enqueue(ListElement *&list, int value, int priority)
{
	if (!list)
	{
		list = new ListElement;
		list->priority = priority;
		list->value = value;
		list->next = nullptr;
		return; 
	}
	ListElement *tmp = list;
	
	int i = 0;
	ListElement *before = tmp;
	while ((priority <= tmp->priority) && (tmp->next))
	{
		before = tmp;
		tmp = tmp->next;
		i++;
	}
	
	ListElement *newElement = new ListElement;
	newElement->next = tmp;
	newElement->priority = priority;
	newElement->value = value;
	if (tmp->priority == priority)
	{
		list = newElement;
		return;
	}
	if (i != 0)
	{
		before->next = newElement;
		return;
	}
	list = newElement;	
}

void enqueue(List *list, int value, int priority)
{
	enqueue(list->first, value, priority);
}

int dequeue(ListElement *&list)
{
	ListElement *tmp = list;
	int value = tmp->value;
	if (list->next)
		list = list->next;
	else
		list = nullptr;
	delete tmp;
	return value;
}

int dequeue(List *list)
{
	if (!list->first)
		return -1;
	return dequeue(list->first);
}

void deleteList(ListElement *list)
{
	while (list)
	{
		ListElement *tmp = list;
		list = list->next;
		delete tmp;
	}
}

void deleteList(List *list)
{
	deleteList(list->first);
	delete list;
}
