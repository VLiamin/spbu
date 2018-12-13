#pragma once

struct Node
{
    char value;
    Node *left;
    Node *right;
};

struct Tree
{
	Node *roof;
};

Tree *createTree();
void push(Tree *&tree, char *string, int i);
int searchTokenEnd(char *string, int i);
void print(Tree *tree);
int count(Tree *tree);

