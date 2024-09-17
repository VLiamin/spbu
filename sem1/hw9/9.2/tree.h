#pragma once

#include "list.h"

struct Node {
    char symbol;
    int value;
    Node *left;
    Node *right;
};

struct Tree {
    Node *root;
};

Tree *createTree();

void build(List *list, Tree *&tree);

void printABC(Tree *tree);

void coding(Tree *tree, List *list, long number);

void deleteTree(Tree *tree);
