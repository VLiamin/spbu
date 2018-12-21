#pragma once
#include "string.h"
#include "list.h"

struct HashTable
{
	List **elements;
	int size;
	int currentSize;
};

HashTable *createHashTable();
void push(HashTable *table, char *word);
double countLoadFactor(HashTable *table);
double returnChainLength(HashTable *table);
int countLoadWords(HashTable *table);
int countEmptyCells(HashTable *table);
void countEachWord(HashTable *table);
int returnMaxChainLength(HashTable *table);
void deleteHashTable(HashTable *table);

