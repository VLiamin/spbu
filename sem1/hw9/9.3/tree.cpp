#include <stdio.h>
#include "tree.h"

using namespace std;

Tree *createTree() {
    return new Tree{nullptr};
}

int findFirstToStart(int first, char *string) {
    while (((string[first] == '(') || (string[first] == ' ')) && (string[first] != '\n')) {
        first++;
    }

    return first;
}

int findSecondToStart(int first, char *string) {

    int parentheses = -1;
    first++;
    if (string[first] == '*') {
        while (parentheses != 0) {
            first++;
            if (string[first] == '(')
                parentheses--;
            if (string[first] == ')')
                parentheses++;

        }

    }
    first = first + 2;

    return first;
}

void buildTree(Node *&node, char *string, int first) {
    if (string[first] == '\n')
        return;
    if (string[first] == '*')
        first++;
    if (string[first] == ' ') {
        node = new Node;
        node->left = nullptr;
        node->right = nullptr;
        node->symbol = '*';
        int firstStart = findFirstToStart(first, string);
        buildTree(node->left, string, firstStart);
        int secondStart = findSecondToStart(first, string);
        buildTree(node->right, string, secondStart);
    }

    if (string[first] == ')') {
        return;
    } else if ((string[first] != '(') && (string[first] != ' ')) {
        node = new Node;
        node->left = nullptr;
        node->right = nullptr;
        node->symbol = string[first];
        return;
    } else if (string[first] != ' ') {
        node = new Node;
        node->leftValue = 0;
        node->rightValue = 1;
        node->left = nullptr;
        node->right = nullptr;
        node->symbol = '*';
        int firstStart = findFirstToStart(first, string);
        buildTree(node->left, string, firstStart);
        int secondStart = findSecondToStart(first, string);
        buildTree(node->right, string, secondStart);
    }
}

void buildTree(Tree *&tree, char *string, int first) {
    buildTree(tree->root, string, first);
}

void printABC(Node *node) {
    if (node == nullptr) {
        return;
    }
    if (node->symbol == '*')
        printf("(");
    printf("%c", node->symbol);
    printABC(node->left);
    printABC(node->right);
    if (node->symbol == '*')
        printf(")");
}

void printABC(Tree *tree) {
    printABC(tree->root);
}

void deleteTree(Node *node) {
    if (node) {
        deleteTree(node->left);
        deleteTree(node->right);
        delete node;
    }
}

void deleteTree(Tree *tree) {
    deleteTree(tree->root);
    delete tree;
}

void decoding(Node *node, char *code) {
    int i = 0;
    while (code[i] != '\0') {
        if (code[i] == '1') {
            node = node->left;
        } else {
            node = node->right;
        }
        i++;
    }
    printf(" %c", node->symbol);
}

void decoding(Tree *tree, char *code) {
    decoding(tree->root, code);
}


