#pragma once

struct ListElement {
    ListElement *next;
    ListElement *before;
    int beforeX;
    int beforeY;
    int x;
    int y;
    int f;
    int g;
};

struct List {
    ListElement *first;
};

List *createList();

void add(List *&list, int x, int y, int f, int g, int beforeX, int beforeY);

bool isNotEmpty(List *list);

int rewrite(List *&listViewed, List *&listNotViewed, int x, int y);

bool isNotElement(List *listViewed, int x, int y);

void findMin(List *listNotViewed, int &f, int &x, int &y);

void printListViewed(List *listViewed, int x, int y);

void print(List *list);

void deleteList(List *list);