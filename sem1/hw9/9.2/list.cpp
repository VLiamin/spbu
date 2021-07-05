#include <stdio.h>
#include "list.h"

List *createList() {
    return new List{nullptr};
}

void push(ListElement *&tmp, char element, int frequency, long code) {
    if (tmp == nullptr) {
        tmp = new ListElement;
        tmp->next = nullptr;
        tmp->symbol = element;
        tmp->frequency = frequency;
        tmp->code = code;
        return;
    } else if (tmp->symbol == element) {
        tmp->frequency++;
        return;
    } else {
        push(tmp->next, element, frequency, code);
        return;
    }
}

void push(List *&list, char element, int frequency, long code) {
    return push(list->first, element, frequency, code);
}

void sort(ListElement *first) {
    ListElement *tmp2 = first;
    ListElement *tmp = first;
    while (first) {
        while (tmp) {
            if (first->frequency > tmp->frequency) {
                int number = first->frequency;
                first->frequency = tmp->frequency;
                tmp->frequency = number;
                char symbol = first->symbol;
                first->symbol = tmp->symbol;
                tmp->symbol = symbol;
            }
            tmp = tmp->next;
        }
        first = first->next;
        tmp = first;
    }
}

void sort(List *list) {
    sort(list->first);
}

bool check(List *list, int &number) {
    if (list->first != nullptr) {
        number = list->first->frequency;
        return true;
    }
    return false;
}

char pop(ListElement *&first, int &number) {
    ListElement *tmp = first->next;
    char element = first->symbol;
    number = first->frequency;
    delete first;
    first = tmp;
    return element;
}

char pop(List *list, int &number) {
    return pop(list->first, number);
}

void write(ListElement *list, char symbol) {
    while (list->symbol != symbol) {
        list = list->next;
    }
    printf(" %d", list->code);
}

void write(List *list, char symbol) {
    write(list->first, symbol);
}

void deleteList(ListElement *element) {
    ListElement *tmp = element;
    while (element) {
        tmp = element;
        element = element->next;
        delete tmp;
    }
}

void deleteList(List *list) {
    deleteList(list->first);
    delete list;
}

void printFrequency(ListElement *element) {
    while (element) {
        printf("\n");
        printf("%c -- %d", element->symbol, element->frequency);
        element = element->next;
    }
}

void printFrequency(List *list) {
    printFrequency(list->first);
}
