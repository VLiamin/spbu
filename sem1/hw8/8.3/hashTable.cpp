#include "hashTable.h"
#include "list.h"
#include <iostream>
#include <stdio.h>
#include "string.h"

const int size = 1500;
const int divisor = 41;
const int multiplier = 256;

HashTable *createHashTable()
{
	HashTable *newTable = new HashTable;
	newTable->size = size;
	newTable->currentSize = 0;
	newTable->elements = new List* [size];
	for (int i = 0; i < size; i++)
	{
		newTable->elements[i] = createList();
	}
	return newTable;
}

int countHash(char *word)
{
	int i = 0;
	long hash = 0;
	printf("%s", word);
	while (word[i] != '\0')
	{
		hash = (hash * multiplier + 'word[i]') % divisor + 1;
		i++;
	}
	return hash;
}

void push(HashTable *table, char *word)
{
	int hash = countHash(word);
	int i = 1;
	int number = 1;
	while (!add(table->elements[hash + i * 2], word, table->currentSize, number))
	{	
		i = i * 2;
	}
}

double countLoadFactor(HashTable *table)
{
	return (double) table->currentSize / table->size;
}

double returnChainLength(HashTable *table)
{
	int result = 0;
	for (int i = 0; i < table->size; i++)
	{
		if (table->elements[i])
		{
			result = result + table->elements[i]->size;
		}
	}
	return (double) result / table->currentSize;
}

int countLoadWords(HashTable *table)
{
	return table->currentSize;
}

int countEmptyCells(HashTable *table)
{
	return table->size - table->currentSize;
}

void countEachWord(HashTable *table)
{
	
	for (int i = 0; i < table->size; i++)
	{
		if (table->elements[i]->first)
		{
			print(table->elements[i]->first->word);
			printf(" - %d", table->elements[i]->first->number);
			printf("\n");
		}
	}
}

void printChain(HashTable *table, int number)
{
	printf("Max example: ");
	print(table->elements[number]->first->word);
	printf("\n");
}

int returnMaxChainLength(HashTable *table)
{
	int result = 0;
	int number = 0;
	for (int i = 0; i < table->size; i++)
	{	
		if (table->elements[i]->first)
		{
			if (table->elements[i]->first->number > result)
			{
				result = table->elements[i]->size;
				number = i;
			}
		}
	}
	printChain(table, number);
	return result;
}

void deleteHashTable(HashTable *table)
{
	for (int i = 0; i < table->size; i++)
	{
		deleteList(table->elements[i]);
	}
	delete table;
}
