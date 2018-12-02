#pragma once

struct Node
{
	int value;                          
	Node *left;
	Node *right;  
	Node *tree;                      
};

struct Tree
{
	Node *root;
};

Tree *createTree();
void push(int number, Tree *&tree);   
void printIncreasing(Tree *tree);
void remove(int number, Tree *tree);
void printDecreasing(Tree *tree);
bool found(int number, Tree *tree);
void printABC(Tree *tree);

