#include <stdio.h>
#include "list.h"

using namespace std;

int main() {
    FILE *file = fopen("text.txt", "r");
    List *list = createList();
    int number = 0;
    while (!feof(file))
    {
        fscanf(file, "%d", &number);
        push(list, number);
    }
    printList(list);
    printf("List symmetry: ");
    if (checkForSymmetry(list))
        printf("YES");
    else
        printf("NO");

    deleteList(list);
    fclose(file);
    return 0;
}