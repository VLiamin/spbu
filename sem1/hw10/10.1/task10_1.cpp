#include <stdio.h>
#include "list.h"
#include <cmath>

void
write(List *listNotViewed, int x, int y, List *listViewed, int **matrix, int finishX, int finishY, int g, int string,
      int column);

int main() {
    FILE *file = fopen("text.txt", "r");
    int string = 0;
    fscanf(file, "%d", &string);
    int column = 0;
    fscanf(file, "%d", &column);
    int **matrix = new int *[column];
    for (int i = 0; i < column; i++) {
        matrix[i] = new int[string];
    }

    for (int i = 0; i < string; i++) {
        for (int j = 0; j < column; j++) {
            fscanf(file, "%d", &matrix[j][i]);
        }
    }
    List *listViewed = createList();
    List *listNotViewed = createList();
    int beginY = 0;
    int beginX = 0;
    int finishY = 0;
    int finishX = 0;
    fscanf(file, "%d", &beginY);
    fscanf(file, "%d", &beginX);
    fscanf(file, "%d", &finishY);
    fscanf(file, "%d", &finishX);

    int f = fabs(beginX - finishX) + fabs(beginY - finishY);
    add(listNotViewed, beginX, beginY, f, 0, -1, -1);
    bool isNotEqual = true;
    int x = beginX;
    int y = beginY;
    int h = f;
    while ((isNotEmpty(listNotViewed)) && (isNotEqual)) {

        findMin(listNotViewed, f, x, y);

        h = fabs(x - finishX) + fabs(y - finishY);
        if (h == 0)
            isNotEqual = false;
        int g = rewrite(listViewed, listNotViewed, x, y);

        write(listNotViewed, x, y, listViewed, matrix, finishX, finishY, g + 1, string, column);

    }
    if (!isNotEqual)
        printListViewed(listViewed, x, y);
    else
        printf("There is no such route");
    for (int i = 0; i < column; i++) {
        delete[] matrix[i];
    }
    delete[] matrix;
    deleteList(listViewed);
    deleteList(listNotViewed);
    fclose(file);
    return 0;
}

void
write(List *listNotViewed, int x, int y, List *listViewed, int **matrix, int finishX, int finishY, int g, int string,
      int column) {
    int f = 0;
    x--;
    if ((x > 0) && (matrix[x - 1][y - 1] == 1) && (isNotElement(listViewed, x, y))) {

        f = fabs(x - finishX) + fabs(y - finishY) + g;
        add(listNotViewed, x, y, f, g, x + 1, y);
    }

    x = x + 2;
    if ((x <= column) && (matrix[x - 1][y - 1] == 1) && (isNotElement(listViewed, x, y))) {

        f = fabs(x - finishX) + fabs(y - finishY) + g;
        add(listNotViewed, x, y, f, g, x - 1, y);
    }
    x--;
    y++;
    if ((y <= string) && (matrix[x - 1][y - 1] == 1) && (isNotElement(listViewed, x, y))) {

        f = fabs(x - finishX) + fabs(y - finishY) + g;
        //printf("%d", y);
        add(listNotViewed, x, y, f, g, x, y - 1);
    }

    y = y - 2;
    if ((y > 0) && (matrix[x - 1][y - 1] == 1) && (isNotElement(listViewed, x, y))) {

        f = fabs(x - finishX) + fabs(y - finishY) + g;
        add(listNotViewed, x, y, f, g, x, y + 1);
    }

}