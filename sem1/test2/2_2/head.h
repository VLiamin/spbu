#pragma once

struct ListElement
{
	int value;                          
	ListElement *next;                    
};

struct List
{
	ListElement *head;
};

List *createList();
void push(List *&list, int number);  
int returnList(List *list, int number);
int pop(List *list, int number);
int print(List *list);
void insert(List *&list, int x, int j);
