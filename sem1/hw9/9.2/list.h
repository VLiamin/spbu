#pragma once

struct ListElement
{
    char symbol;
    int number;
    ListElement *next;
};

struct List
{
	ListElement *first;
};

List *createList();
void push(List *&list, char element, long number);
void sort(List *list);
void deleteList(List *list);
bool check(List *list, int &number);
char pop(List *list, int &number);
void write(List *list, char symbol);
void deleteList(List *list);
