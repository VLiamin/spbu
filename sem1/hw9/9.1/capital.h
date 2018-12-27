#pragma once
#include "list.h"

struct Capital
{
	List **towns;
	int count;
};

Capital *createCapital(int sity);
void pushCapital(Capital *capital, int sity, int i);
void printCapital(Capital *capital);
void deleteOneElement(Capital *capital, int **matrix, int element);
void deleteCapital(Capital *capital);
