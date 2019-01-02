#include "capital.h"
#include <stdio.h>

Capital *createCapital(int city) {
    Capital *capital = new Capital;
    capital->towns = new List *[city];
    capital->count = city;
    for (int i = 0; i < city; i++) {
        capital->towns[i] = createList();
    }
    return capital;
}

void pushCapital(Capital *capital, int city, int i) {
    pushList(capital->towns[i], city);
}

void printCapital(Capital *capital) {
    for (int i = 0; i < capital->count; i++) {
        printf("%d country: ", i + 1);
        printList(capital->towns[i]);
        printf("\n");
    }
}

void deleteOneElement(Capital *capital, int **matrix, int element) {
    for (int i = 0; i < capital->count; i++) {
        deleteOneElement(capital->towns[i], matrix, element);
    }
}

void deleteCapital(Capital *capital) {
    for (int i = 0; i < capital->count; i++) {
        deleteList(capital->towns[i]);
    }
    delete capital->towns;
    delete capital;
}
