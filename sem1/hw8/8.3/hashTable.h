#pragma once

#include "string.h"

const int size = 1500;
const int modulo = 41;
const int multiplier = 256;

struct Bucket {
    String *word;
    int repeats;
    int probes;
};

struct HashTable {
    Bucket **elements;
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

