#include "hashTable.h"
#include <iostream>

HashTable *createHashTable() {
    HashTable *newTable = new HashTable;
    newTable->size = size;
    newTable->currentSize = 0;
    newTable->elements = new Bucket *[size];
    for (int i = 0; i < size; i++) {
        newTable->elements[i] = new Bucket{nullptr, 0, 0};

    }
    return newTable;
}

int countHash(char *word) {
    int i = 0;
    long hash = 0;
    while (word[i] != '\0') {
        hash = (hash * multiplier + word[i]) % modulo + 1;
        i++;
    }
    return hash;
}

bool writeWord(int &probes, Bucket *&bucket, char *word, int &currentSize, int &number) {
    if (!bucket->word) {
        int i = 0;
        probes = number;
        bucket->repeats = 1;
        bucket->word = createString();
        add(bucket->word, word, i);
        currentSize++;
        return true;
    } else {
        if (compare(bucket->word, word)) {
            bucket->repeats++;
            return true;
        }
        number++;
        return false;
    }
}

void push(HashTable *table, char *word) {
    int hash = countHash(word);
    int i = 1;
    int number = 1;
    while (!writeWord(table->elements[hash + i * 2]->probes, table->elements[hash + i * 2], word, table->currentSize,
                      number)) {
        i = i * 2;

    }
}

double countLoadFactor(HashTable *table) {
    return (double) table->currentSize / table->size;
}

double returnChainLength(HashTable *table) {
    int result = 0;
    for (int i = 0; i < table->size; i++) {
        if (table->elements[i]) {
            result = result + table->elements[i]->probes;
        }
    }
    return (double) result / table->currentSize;
}

int countLoadWords(HashTable *table) {
    return table->currentSize;
}

int countEmptyCells(HashTable *table) {
    return table->size - table->currentSize;
}

void countEachWord(HashTable *table) {

    for (int i = 0; i < table->size; i++) {
        if (table->elements[i]->word) {
            print(table->elements[i]->word);
            printf(" - %d", table->elements[i]->repeats);
            printf("\n");
        }
    }
}

void printChain(HashTable *table, int number) {
    int i = 0;
    printf("Max example: ");
    while (i < size) {
        if ((table->elements[i]) && (table->elements[i]->probes == number)) {
            print(table->elements[i]->word);
            printf(" ");
        }
        i++;
    }
    printf("\n");
}

int returnMaxChainLength(HashTable *table) {
    int result = 0;
    int number = 0;
    for (int i = 0; i < size; i++) {
        if (table->elements[i]) {
            if (table->elements[i]->probes > result) {
                result = table->elements[i]->probes;
            }
        }
    }
    printChain(table, result);
    return result;
}

void deleteHashTable(HashTable *table) {
    for (int i = 0; i < table->size; i++) {
        if (table->elements[i]->word) {
            deleteString(table->elements[i]->word);
        }
        delete table->elements[i];
    }
    delete table;
}
