#pragma once

struct ListElement
{
    int value;
    int priority;
    ListElement *next;
};

struct List
{
	ListElement *first;
};

List *createList();
void enqueue(List *list, int value, int priority);
int dequeue(List *list);
void deleteList(List *list);
