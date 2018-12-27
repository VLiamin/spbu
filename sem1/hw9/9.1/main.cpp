#include <stdio.h>
#include "graph.h"
#include "capital.h"

using namespace std;
int lengthString = 20;

int main(int argc, char *argv[])
{
	char numbers[lengthString];
	FILE *f = fopen("text.txt", "r");
	int i = 0;
	int n = 0;
	int m = 0;
	int town1 = 0;
	int town2 = 0;
	int length = 0;
	int sity = 0;
	int number = 0;
	fscanf(f, "%d", &n);
	fscanf(f, "%d", &m);
	Graph *graph = createGraph(n);
	fillInTheMatrix(graph);
	
	for (i = 0; i < m; i++)
	{
		fscanf(f, "%d", &town1);
		fscanf(f, "%d", &town2);
		fscanf(f, "%d", &length);
		pushGraph(graph, town1, town2, length);
	}
	
	fscanf(f, "%d", &number);
	Capital *capital = createCapital(number);
	
	int *metropolis = new int[number];
	for (i = 0; i < number; i++)
	{
		fscanf(f, "%d", &sity);
		pushCapital(capital, sity, i);	
		metropolis[i] = sity;
	}
	deleteCapital(graph, metropolis, number);
	fillCountries(graph, number, capital);
	printCapital(capital);
	delete [] metropolis;
	deleteGraph(graph);
	deleteCapital(capital);
	return 0;
}
