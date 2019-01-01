#include "tree.h"
#include <stdio.h>

int searchTokenStart(char *str, int i) {
    int sum = 0;
    if (str[i] == '(') {
        sum++;
        i++;
        while (sum != 0) {
            if (str[i] == '(')
                sum++;
            else if (str[i] == ')')
                sum--;
            i++;
        }
        while (str[i] == ' ') {
            i++;
        }
    } else {
        i++;
        while (str[i] != ' ') {
            i++;
        }
        while (str[i] == ' ') {
            i++;
        }
    }
    return i;
}

Tree *createTree() {
    return new Tree{nullptr};
}

void push(Node *&node, char *str, int i) {
    if (str[i] == '(') {
        node = new Node;
        i++;
        while (str[i] == ' ') {
            i++;
        }
        node->symbol = str[i];
        node->number = 0;
        node->right = nullptr;
        node->left = nullptr;
        i++;
        while (str[i] == ' ') {
            i++;
        }
        int firstTokenStart = i;
        int secondTokenStart = searchTokenStart(str, firstTokenStart);
        push(node->left, str, firstTokenStart);
        push(node->right, str, secondTokenStart);
        return;
    } else {
        node = new Node;
        node->number = 0;
        node->symbol = 'b';
        while ((str[i] >= '0') && (str[i] <= '9')) {
            node->number = node->number * 10 + str[i] - '0';
            i++;
        }
        node->left = nullptr;
        node->right = nullptr;
        return;
    }
}

void push(Tree *&tree, char *string, int i) {
    push(tree->root, string, i);
}

void print(Node *node) {
    if (node == nullptr)
        return;
    if (node->left != nullptr)
        printf("(");
    print(node->left);
    if (node->symbol != 'b')
        printf(" %c ", node->symbol);
    else
        printf("%d", node->number);
    print(node->right);
    if (node->left != nullptr) {
        printf(")");
    }

}

void print(Tree *tree) {
    print(tree->root);
}

int count(Node *tree) {
    if (tree->left == nullptr) {
        return tree->number;
    }

    switch (tree->symbol) {
        case '+':
            return count(tree->left) + count(tree->right);
        case '-':
            return count(tree->left) - count(tree->right);
        case '*':
            return count(tree->left) * count(tree->right);
        case '/':
            return count(tree->left) / count(tree->right);
    }
}

int count(Tree *tree) {
    return count(tree->root);
}

void deleteNode(Node *node) {
    if (node) {
        deleteNode(node->right);
        deleteNode(node->left);
        delete node;
    }

}

void deleteTree(Tree *tree) {
    deleteNode(tree->root);
    delete tree;
}
