#include "list.h"
#include <stdio.h>

List *createList() {
    return new List{nullptr};
}

void pushList(ListElement *&element, int sity) {
    if (!element) {
        element = new ListElement;
        element->next = nullptr;
        element->town = sity;
        return;
    }
    pushList(element->next, sity);
}

void pushList(List *&list, int sity) {
    pushList(list->element, sity);
}

int findTown(ListElement *element, int number) {

    if (number == -1) {
        return element->town;
    }
    while ((number != element->town) && (element->next != nullptr)) {
        element = element->next;
    }
    if (element->next == nullptr)
        return -1;
    return element->next->town;
}

int findTown(List *list, int number) {
    return findTown(list->element, number);
}

void printList(ListElement *list) {
    while (list) {
        printf("%d ", list->town);
        list = list->next;
    }
}

void printList(List *list) {
    printList(list->element);
}

void deleteOneElement(ListElement *list, int **matrix, int element) {
    while (list) {
        matrix[element][list->town - 1] = -1;
        matrix[list->town - 1][element] = -1;
        list = list->next;
    }
}

void deleteOneElement(List *list, int **matrix, int element) {
    deleteOneElement(list->element, matrix, element);
}

void deleteList(ListElement *element) {
    while (element) {
        ListElement *current = element;
        element = element->next;
        delete current;
    }
}

void deleteList(List *list) {
    deleteList(list->element);
    delete list;
}
