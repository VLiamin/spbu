#include "head.h"
#include <stdio.h>

List *createList()
{
    return new List {nullptr};
}

void push(ListElement *&first, ListElement *&last, char number) 
{
	if (first == nullptr)
	{
		first = new ListElement;
		first->value = number;
		first->before = nullptr;
		first->next = nullptr;
		last = first;
		return;
	}
	ListElement *tmp = first;
	while (tmp)
	{
		last = tmp;
		tmp = tmp->next;
	}
	tmp = new ListElement;
	tmp->before = last;
	tmp->next = nullptr;
	tmp->value = number;
	last = tmp;
	return;
}

void push(List *&list, char information)
{
	push(list->first, list->last, information);
}

bool check(ListElement *&first, ListElement *&last)
{
	bool compare = true;
	if (first->value == last->value)
	{
		
		ListElement *tmp = first;
		first = first->next;
		delete tmp;
		tmp = last;
		last = last->before;
		delete tmp;
		printf("%d", last->value);
	}
	else
	{
		ListElement *tmp = first;
		first = first->next;
		delete tmp;
		tmp = last;
		last = last->before;
		delete tmp;
		compare = false;
	}
	return compare;
}

bool check(List *&list)
{
	check(list->first, list->last);
	if (list->first == nullptr)
		delete list;
}
