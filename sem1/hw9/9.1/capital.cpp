#include "capital.h"
#include "list.h"
#include <stdio.h>

Capital *createCapital(int sity)
{
	Capital *capital = new Capital;
	capital->towns = new List* [sity];
	capital->count = sity;
	for (int i = 0; i < sity; i++)
	{
		capital->towns[i] = createList();
	}
	return capital;
}

void pushCapital(Capital *capital, int sity, int i)
{
	pushList(capital->towns[i], sity);
}

void printCapital(Capital *capital)
{
	for (int i = 0; i < capital->count; i++)
	{
		printf("%d country: ", i + 1);
		printList(capital->towns[i]);
		printf("\n");
	}
}

void deleteOneElement(Capital *capital, int **matrix, int element)
{
	for (int i = 0; i < capital->count; i++)
	{
		deleteOneElement(capital->towns[i], matrix, element);
	}
}
void deleteCapital(Capital *capital)
{
	for (int i = 0; i < capital->count; i++)
	{
		deleteList(capital->towns[i]);
	}
	delete capital;
}
