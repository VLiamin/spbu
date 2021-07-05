#include <stdio.h>
#include "list.h"


List *createList()
{
    return new List {nullptr};
}

void add(ListElement *&element, int x, int y, int f, int g, int beforeX, int beforeY)
{

    if (element == nullptr)
    {

        element = new ListElement;
        element->before = nullptr;
        element->next = nullptr;
        element->f = f;
        element->g = g;
        element->x = x;
        element->y = y;
        if (beforeX < 0)
        {
            element->beforeX = -1;
            element->beforeY = -1;
        }
        else
        {

            element->beforeX = beforeX;
            element->beforeY = beforeY;
        }
        return;
    }

    ListElement *tmp = element;
    element = element->before;
    element = new ListElement;
    element->before = nullptr;
    element->next = tmp;
    element->f = f;
    element->g = g;
    element->x = x;
    element->y = y;

    if (beforeX < 0)
    {
        element->beforeX = -1;
        element->beforeY = -1;
    }
    else
    {
        element->beforeX = beforeX;
        element->beforeY = beforeY;
    }

    return;
}


void add(List *&list, int x, int y, int f, int g, int beforeX, int beforeY)
{
    add(list->first, x, y, f, g, beforeX, beforeY);
}

bool isNotEmpty(ListElement *element)
{
    if (element != nullptr) return true;

    return false;
}

bool isNotEmpty(List *list)
{
    return isNotEmpty(list->first);
}

int rewrite(ListElement *&listViewed, ListElement *&listNotViewed, int x, int y)
{

    ListElement *tmp = listViewed;
    if (listViewed)
    {
        listViewed = listViewed->before;
        listViewed = new ListElement;
        listViewed->next = tmp;
    }
    else
    {
        listViewed = new ListElement;
        listViewed->next = nullptr;
    }

    listViewed->before = nullptr;
    tmp = listNotViewed;
    ListElement *before = listNotViewed->before;
    ListElement *next = listNotViewed->next;

    while (listNotViewed)
    {
        if ((listNotViewed->x == x) && (listNotViewed->y == y))
        {

            if (before)
            {
                before->next = next;
            }
            if (next)
            {
                next->before = before;
            }

            listViewed->y = listNotViewed->y;
            listViewed->x = listNotViewed->x;
            listViewed->f = listNotViewed->f;
            listViewed->g = listNotViewed->g;
            listViewed->beforeY = listNotViewed->beforeY;
            listViewed->beforeX = listNotViewed->beforeX;

            if (tmp != listNotViewed)
            {

                delete listNotViewed;
                listNotViewed = tmp;
            }
            else
            {

                delete listNotViewed;

                if (next)
                    listNotViewed = next;
                else
                    listNotViewed = nullptr;

            }
            return listViewed->g;
        }

        before = listNotViewed;
        listNotViewed = listNotViewed->next;
        next = listNotViewed->next;
    }

}

int rewrite(List *&listViewed, List *&listNotViewed, int x, int y)
{
    rewrite(listViewed->first, listNotViewed->first, x, y);
}

bool isNotElement(ListElement *listViewed, int x, int y)
{

    bool isNotEqual = true;
    while ((listViewed) && (isNotEqual))
    {

        if ((listViewed->x == x) && (listViewed->y == y))
            isNotEqual = false;
        listViewed = listViewed->next;
    }

    return isNotEqual;
}

bool isNotElement(List *listViewed, int x, int y)
{
    return isNotElement(listViewed->first, x, y);
}

void findMin(ListElement *listNotViewed, int &f, int &x, int &y)
{
    f = listNotViewed->f;
    x = listNotViewed->x;
    y = listNotViewed->y;
    while (listNotViewed)
    {
        if (f > listNotViewed->f)
        {
            f = listNotViewed->f;
            x = listNotViewed->x;
            y = listNotViewed->y;
        }
        listNotViewed = listNotViewed->next;
    }
}

void findMin(List *listNotViewed, int &f, int &x, int &y)
{
    findMin(listNotViewed->first, f, x, y);
}

void printListViewed(ListElement *listViewed, int x, int y)
{
    ListElement *tmp = listViewed;
    while (x != -1)
    {
        if ((listViewed->x == x) && (listViewed->y == y))
        {
            printf("%d %d\n", y, x);
            x = listViewed->beforeX;
            y = listViewed->beforeY;
            listViewed = tmp;
        }
        listViewed = listViewed->next;
    }
}

void printListViewed(List *listViewed, int x, int y)
{
    printListViewed(listViewed->first, x, y);
}

void print(ListElement *element)
{
    while (element)
    {
        printf("%d %d\n", element->y, element->x);
        element = element->next;
    }
}

void print(List *list)
{
    print(list->first);
}

void deleteList(ListElement *tmp)
{
    ListElement *p = tmp;
    while (tmp)
    {
        tmp = tmp->next;
        delete p;
        p = tmp;
    }
    return;
}

void deleteList(List *list)
{
    deleteList(list->first);
    delete list;
}