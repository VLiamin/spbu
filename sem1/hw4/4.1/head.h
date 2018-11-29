#ifndef head_H
#define head_H
struct List
{
	int number;
	List *next;
};	

List *createList();
List *add(List *tmp, int number);
List *kill(List *tmp, int i, int dead);
void print(List *head);	

#endif
