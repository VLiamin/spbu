#pragma once

const int length = 15;

struct ListElement
{
    char information[length];
    ListElement *next;
};

struct List
{
	ListElement *first;
};

List *createList();
void push(List *&list, char information[length]);
void save(List *list, char *phone, FILE *f);
char *search(List *list, char *facts, int number);
void deleteList(List *list);
