#include <stdio.h>
#include "hashTable.h"

using namespace std;

const int length = 100;

int main() {
    FILE *f = fopen("text.txt", "r");
    if (!f) {
        printf("Error: File \"text.txt\" not found");
        return 1;
    }
    HashTable *table = createHashTable();
    char word[length];
    int i = 0;
    while (!feof(f)) {
        fscanf(f, "%s", word);
        push(table, word);
        printf("%s\n", word);
    }
    printf("Load Factor: %f\n", countLoadFactor(table));
    printf("Average number of samples: %f\n", returnChainLength(table));
    printf("Number of words added: %d\n", countLoadWords(table));
    printf("Number of empty cells: %d\n", countEmptyCells(table));
    countEachWord(table);
    printf("Max chain length elements: %d", returnMaxChainLength(table));
    deleteHashTable(table);
    fclose(f);
    return 0;
}
