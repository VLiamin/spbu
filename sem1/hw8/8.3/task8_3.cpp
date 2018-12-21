#include <stdio.h>
#include "hashTable.h"

using namespace std;

const int length = 100;

int main()
{
	FILE *f = fopen("text.txt", "r");
	HashTable *table = createHashTable();
	char word[length];
	int i = 0;
	while (!feof(f))
	{
		i++;
		if (i != 1)
		{
			push(table, word);
		}	
			
		fscanf(f, "%s", word);
		
	} 
	printf("Load Factor: %f\n", countLoadFactor(table));
	printf("Average number of samples: %f\n", returnChainLength(table));
	printf("Number of words added: %d\n", countLoadWords(table));
	printf("Number of empty cells: %d\n", countEmptyCells(table));
	countEachWord(table);
	printf("Max chain length elements: %d", returnMaxChainLength(table));
	deleteHashTable(table);
	return 0;
}
