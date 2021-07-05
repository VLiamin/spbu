#include <stdio.h>
#include "tree.h"

using namespace std;

const int length = 100;

int main(int argc, char *argv[]) {
    Tree *tree = createTree();
    FILE *f = fopen("text.txt", "r");
    char str[length];
    fgets(str, length, f);
    push(tree, str, 0);
    printf("Expression: ");
    print(tree);
    printf("\n");
    printf("Value: %d", count(tree));
    deleteTree(tree);
    fclose(f);
    return 0;
}


