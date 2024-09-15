#pragma once

struct Node {
    int number;
    char symbol;
    Node *left;
    Node *right;
};

struct Tree {
    Node *root;
};

Tree *createTree();

void push(Tree *&tree, char *str, int i);

void print(Tree *tree);

int count(Tree *tree);

void deleteTree(Tree *tree);


