#include <stdio.h>
#include "tree.h"

const int length = 100;

int main() {
    FILE *f = fopen("text.txt", "r");
    Tree *tree = createTree();
    char string[length];
    char code[length];
    fgets(string, length, f);
    buildTree(tree, string, 1);
    printABC(tree);
    printf("\n");
    while (!feof(f)) {
        fscanf(f, "%s", code);
        decoding(tree, code);
    }
    deleteTree(tree);
    fclose(f);
    return 0;
}

