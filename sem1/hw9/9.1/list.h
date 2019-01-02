#pragma once

struct ListElement {
    ListElement *next;
    int town;
};

struct List {
    ListElement *element;
};

List *createList();

void pushList(List *&list, int sity);

int findTown(List *list, int number);

void printList(List *list);

void deleteOneElement(List *list, int **matrix, int element);

void deleteList(List *list);
