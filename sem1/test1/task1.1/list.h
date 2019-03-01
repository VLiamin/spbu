#pragma once

struct ListElement{
    ListElement *next;
    ListElement *prev;
    int value;
};

struct List{
    ListElement *first;
    ListElement *last;
};

List *createList();
void push(List *&list, int number);
bool checkForSymmetry(List *list);
void deleteList(List *list);
void printList(List *list);