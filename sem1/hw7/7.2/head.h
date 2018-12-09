#pragma once

struct Node
{
	int value; 
	int height;                         
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
void printIn(Tree *tree);
void printDe(Tree *tree);
bool found(int number, Tree *tree);
void printABC(Tree *tree);
unsigned char height(Tree* p);
int bfactor(Node* p);
void fixheight(Node* p);
Node* rotateright(Node* p);
Node* rotateleft(Node* q);
Node* balance(Node* p);  
Node* findmin(Node* p);
Node* removemin(Node* p);
void remove(Tree *&tree, int number);
void deleteTree(Tree *tree);



