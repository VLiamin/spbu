#ifndef head_H
#define head_H
const int length = 15;

struct List
{
    char name[length];
    char number[length];
    List *next;
};

struct List *push(List *tail, char *forename, char *phone);
bool copy(List *&head, List *&element);
struct List *create(List *head, char *forename, char *phone);
void print(List *head);

#endif
