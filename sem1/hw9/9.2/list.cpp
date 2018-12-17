#include <stdio.h>
#include "list.h"

List *createList()
{
	return new List {nullptr};
}

void push(ListElement *&tmp, char element, long number) 
{
	if (tmp == nullptr)
	{
		tmp = new ListElement;
		tmp->next = nullptr;
		tmp->number = number;
		tmp->symbol = element;
		return;
	}
	if (tmp->symbol == element)
	{
		tmp->number++;
		return;
	}
	else
	{
		push(tmp->next, element, number);
		return;
	}
}

void push(List *&list, char element, long number)
{
	return push(list->first, element, number);
}

void sort(ListElement *first)
{
	ListElement *tmp2 = first;
	ListElement *tmp = first;
	while (first)
	{
		while (tmp)
		{
			if (first->number > tmp->number)
			{
				int number = first->number;
				first->number = tmp->number;
				tmp->number = number;
				char symbol = first->symbol;
				first->symbol = tmp->symbol;
				tmp->symbol = symbol;
			}
			tmp = tmp->next;
		}
		first = first->next;
		tmp = first;
	}
}

void sort(List *list)
{
	sort(list->first);
}

bool check(List *list, int &number)
{
	if (list->first != nullptr)
	{
		number = list->first->number;
		return true;
	}
	return false;
}

char pop(ListElement *&first, int &number)
{	
	ListElement *tmp = first->next;	
	char element = first->symbol;
	number = first->number;
	delete first;
	first = tmp;
	return element;
}

char pop(List *list, int &number)
{
	return pop(list->first, number);
}

void write(ListElement *list, char symbol)
{
	while (list->symbol != symbol)
	{
		list = list->next;
	}
	printf(" %d", list->number);
}
void write(List *list, char symbol)
{
	write(list->first, symbol);
}

void deleteList(List *list)
{
	delete list;
}
