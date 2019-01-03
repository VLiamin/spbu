#pragma once

struct Node {
    char symbol;
    int leftValue;
    int rightValue;
    Node *left;
    Node *right;
};

struct Tree {
    Node *root;
};

Tree *createTree();

void buildTree(Tree *&tree, char *string, int first);

void printABC(Tree *tree);

void deleteTree(Tree *tree);

void decoding(Tree *tree, char *code);


