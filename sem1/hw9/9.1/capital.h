#pragma once

#include "list.h"

struct Capital {
    List **towns;
    int count;
};

Capital *createCapital(int city);

void pushCapital(Capital *capital, int city, int i);

void printCapital(Capital *capital);

void deleteOneElement(Capital *capital, int **matrix, int element);

void deleteCapital(Capital *capital);
