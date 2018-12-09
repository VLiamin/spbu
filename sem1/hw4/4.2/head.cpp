#include <stdio.h>
#include <string.h>
#include "head.h"

List *createList()
{
    return new List {nullptr};
}

void push(ListElement *&tmp, char information[length]) 
{
	if (tmp == nullptr)
	{
		tmp = new ListElement;
		tmp->next = nullptr;
		int i = 0;
		while (information[i] != '\0')
		{
			tmp->information[i] = information[i];
			i++;
		} 
		if (tmp->information[i - 1] != '\n')
			tmp->information[i] = '\n';
		return;
	}
    else
    {
    	push(tmp->next, information);
    	return;
	}
}

void push(List *&list, char information[length])
{
	return push(list->first, information);
}

void save(ListElement *tmp, char *phone, FILE *f)
{
	bool areEqual = false;
	
	while ((!areEqual) && (tmp))
	{
		int i = 0;
		areEqual = true;
		tmp = tmp->next;
		while (tmp->information[i] != '\n')
		{
			if (tmp->information[i] != phone[i])
				areEqual = false;
			i++;
		}	
	}

	tmp = tmp->next;
	while (tmp)
	{
		fprintf(f, "%s", tmp->information);
		tmp = tmp->next;
	}
	return;
}

void save(List *list, char *phone, FILE *f)
{
	save(list->first, phone, f);
}

char *search(ListElement *tmp, char *facts, int number)
{
	bool areEqual = false;
	if (number == 1)
	{
		while ((!areEqual) && (tmp))
		{
			int i = 0;
			areEqual = true;
			while (facts[i] != '\0')
			{
				if (tmp->information[i] != facts[i])
					areEqual = false;
				i++;
			}
			tmp = tmp->next;
		}
		return tmp->information;
	}
	else 
	{
		ListElement *p = tmp;
		while ((!areEqual) && (tmp))
		{
			p = tmp;
			tmp = tmp->next;
			int i = 0;
			areEqual = true;
			while (facts[i] != '\0')
			{
				if (tmp->information[i] != facts[i])
					areEqual = false;
				i++;
			}
			
		}
		return p->information;
	}
}

char *search(List *list, char *facts, int number)
{
	return search(list->first, facts, number);
}

void deleteList(ListElement *tmp)
{
	ListElement *p = tmp;
	while (tmp)
	{
		tmp = tmp->next;
		delete p;
		p = tmp;
	}
	return;
}

void deleteList(List *list)
{
	deleteList(list->first);
	delete list;
}
