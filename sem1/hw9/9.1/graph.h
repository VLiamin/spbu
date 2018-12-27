#pragma once
#include "capital.h"
#include "list.h"

struct Graph
{
	int **matrix;
	int size;
};

Graph *createGraph(int size);
void pushGraph(Graph *&graph, int town1, int town2, int length);
void fillCountries(Graph *graph, int number, Capital *capital);
void fillInTheMatrix(Graph *&graph);
void deleteCapital(Graph *graph, int *metropolis, int number);
void deleteGraph(Graph *graph);
