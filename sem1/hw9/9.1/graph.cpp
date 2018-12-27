#include "graph.h"
#include "capital.h"
#include "list.h"
#include <stdio.h>

void findMin(int **matrix, int number, Capital *&capital, int size);

Graph *createGraph(int size)
{
	Graph *newGraph = new Graph;
	newGraph->size = size;
	int **matrix = new int * [size];
	for (int i = 0; i < size; i++)
	{
		matrix[i] = new int[size];
	}
	newGraph->matrix = matrix;
	return newGraph;
}

void pushGraph(Graph *&graph, int town1, int town2, int length)
{

	graph->matrix[town1 - 1][town2 - 1] = length;
	
	graph->matrix[town2 - 1][town1 - 1] = length;
}

void fillInTheMatrix(Graph *&graph)
{
	for (int i = 0; i < graph->size; i++)
	{
		for (int j = 0; j < graph->size; j++)
		{
		
			graph->matrix[j][i] = -1;
		}
	}
}
void fillCountries(Graph *graph, int number, Capital *capital)
{
	int i = 0;
	while (i < graph->size)
	{
		findMin(graph->matrix, i % number, capital, graph->size);
		i++;
	}
}

void findMin(int **matrix, int number, Capital *&capital, int size)
{	
	
	int digit = -1;
	digit = findTown(capital->towns[number], digit);
	int minNumber = -1;
	int min = -1;
	int i = 0;
	while (digit != -1)
	{
		if (((matrix[digit - 1][i] < min) && (matrix[digit - 1][i] > 0)) || ((matrix[digit - 1][i] > 0) && (min < 0)))
		{
			minNumber = 10 * digit + i;
			min = matrix[digit - 1][i];
		}
		i++;
		if (i == size)
		{
			digit = findTown(capital->towns[number], digit);
			i = 0;
		}
	}
	if (minNumber % 10 + 1 > 0)
	{
		pushList(capital->towns[number], minNumber % 10 + 1);
		deleteOneElement(capital, matrix, minNumber % 10);
	}
	return;
}

void deleteCapital(Graph *graph, int *metropolis, int number)
{
	
	for (int i = 0; i < number; i++)
	{
		for (int j = i + 1; j < number; j++)
		{
			graph->matrix[metropolis[j] - 1][metropolis[i] - 1] = -1; 
			graph->matrix[metropolis[i] - 1][metropolis[j] - 1] = -1; 
		}
	}
}

void deleteGraph(Graph *graph)
{
	for (int i = 0; i < 2; i++)
	{
		delete [] graph->matrix[i];
	}
	delete [] graph->matrix;
	delete graph;
}
