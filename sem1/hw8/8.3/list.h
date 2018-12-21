#pragma once
#include "string.h"

struct ListElement
{
	String *word;
	int number;
	ListElement *next;
};

struct List
{
	ListElement *first;
	int size;
};

List *createList();
bool add(List *list, char *tmp, int &currentSize, int &number);
void deleteList(List *list);
