#include "head.h"
#include <stdio.h>
#include <string.h>

struct List *push(List *tail, char *forename, char *phone) 
{
    List *newElement = new List;
    newElement->next = nullptr;
    strcpy(newElement->name, forename);
    strcpy(newElement->number, phone);
    tail->next = newElement;
    return newElement;
}

bool copy(List *&head, List *&element) 
{
    element = head;
    if (element == nullptr)
        return false;
    head = (head)->next;
    return true;
}

struct List *create(List *head, char *forename, char *phone) 
{
    head = new List;
    head->next = nullptr;
    strcpy(head->name, forename);
    strcpy(head->number, phone);
    return head;
}

void print(List *head) 
{
    if (head != nullptr) 
	{
        print(head->next);
    }

}
