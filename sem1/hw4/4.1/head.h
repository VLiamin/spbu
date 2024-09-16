#ifndef head_H
#define head_H
struct ListElement
{
	int number;
	ListElement *next;
};

struct List
{
	ListElement *head;
};	

List *createList();
void add(List *&list, int number);
void pop(List *list, int dead);
void print(List *list);	
void turnIntoCyclical(List *list);
#endif
