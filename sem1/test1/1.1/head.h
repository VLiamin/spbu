#pragma once

const int length = 15;

struct ListElement
{
    char value;
    ListElement *before;
    ListElement *next;
};

struct List
{
	ListElement *first;
	ListElement *last;
};

List *createList();
void push(List *&list, char information);
bool check(List *&list);
