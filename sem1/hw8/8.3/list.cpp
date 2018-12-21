#include "list.h"
#include "string.h"
#include <stdio.h>

List *createList()
{
	return new List {nullptr, 0};
}

bool add(int &size, ListElement *&list, char *tmp, int &currentSize, int &number)
{
	if (!list)
	{
		int i = 0;
		list = new ListElement;
		size = number;
		list->number = 1;
		list->word = createString();
		add(list->word, tmp, i);
		currentSize++;
		return true;		
	}
	else
	{
		if (compare(list->word, tmp))
		{
			list->number++;
			return true;
		}
		number++;
		return false;
	}
}

bool add(List *list, char *tmp, int &currentSize, int &number)
{
	return add(list->size, list->first, tmp, currentSize, number);
}

void deleteList(List *list)
{
	deleteString(list->first->word);
	delete list->first;
	delete list;
}
