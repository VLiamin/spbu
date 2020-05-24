#include <stdio.h>
#include "list.h"

List *createList() {
    List *list = new List;
    list->first = nullptr;
    list->last = nullptr;
    return list;
}

void push(ListElement *&first, ListElement *&last, int number) {
    while (first != nullptr)
        first = first->next;
    first = new ListElement;
    first->prev = last;
    first->next = nullptr;
    first->value = number;
    if (last != nullptr)
        last->next = first;
    last = first;
    while (first->prev != nullptr)
        first = first->prev;
}

void push(List *&list, int number) {
    push(list->first, list->last, number);
}

bool checkForSymmetry(ListElement *first, ListElement *last) {
    while (first != last) {
        if (first->value != last->value)
            return false;

        last = last->prev;
        first = first->next;
    }
    return true;
}

bool checkForSymmetry(List *list) {
    checkForSymmetry(list->first, list->last);
}

void deleteList(ListElement *first) {
    while (first) {
        ListElement *current = first;
        first = first->next;
        delete current;
    }
}

void deleteList(List *list) {
    deleteList(list->first);
    delete list;
}

void printList(ListElement *first) {
    printf("List: ");
    while (first != nullptr) {
        printf(" %d", first->value);
        first = first->next;
    }
    printf("\n");
}

void printList(List *list) {
    printList(list->first);
}