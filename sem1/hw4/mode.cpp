#include <malloc.h>
#include <cstddef>
#include <stdio.h>
#include "head.h"
	
void survive(int number, int dead)
{
	
	int sum = 0;
	List *p = nullptr;
	List *tmp = new List;
	tmp->x = 1;
	tmp->next = nullptr;
	List *head = tmp; 
	
	for (int i = 0; i < number; i++)
	{
		tmp->next = new List;
		tmp->next->next = nullptr;
		tmp = tmp->next;
		tmp->x = i + 1;	 
		if (i == 0)
			head = tmp;	
	}
	
	tmp->next = head;
	tmp = tmp->next;
	
	for (int i = 0; i < number - 1; i++)
	{
		for (int j = 0; j < dead - 2; j++)
		{
			tmp = tmp->next;
		}
		p = tmp->next;
		tmp->next = tmp->next->next;
		tmp = tmp->next;
		delete p;
	}
	
	printf("Who survived:");
	printf(" %d", tmp->x);
	delete tmp;
	return;
}
