#include <stdio.h>
#include "head.h"

Node* balance(Node* p);

Tree *createTree()
{
	return new Tree {nullptr};
}

void push(int number, Node *&tree) 
{
	if (!tree) 
	{
		tree = new Node;                
		tree->value = number;                 
		tree->left = nullptr;
		tree->right = nullptr;
		return;
	}
	else
	{
		if (tree->value == number)
			return;
	}
	if (number < tree->value )
		push(number, tree->left);
	else
		push(number, tree->right);
	tree = balance(tree);
}  

void push(int number, Tree *&tree) 
{
	push(number, tree->root);
}

void printDe(Node *tree)
{
	if (tree == nullptr) 
		return;                  
	else 
	{
		printDe(tree->right);                  
		printf(" %d", tree->value);            
	}
	printDe(tree->left);                       
}

void printDe(Tree *tree)
{
	printDe(tree->root);
}

void printIn(Node *tree)
{
	if (tree == nullptr) 
		return;                  
	else 
	{
		printIn(tree->left);                   
		printf(" %d", tree->value);            
	}
	printIn(tree->right);                       
}

void printIn(Tree *tree)
{
	printIn(tree->root);
}

bool found(int number, Node *tree)
{   
	Node *tmp = tree;         
	while (tree != nullptr)
	{
		if (number > tree->value)
			tree = tree->right;
		else if (number < tree->value)
			tree = tree->left;
		else
		{
			tree = tmp;
			return true;
		}
	}
	tree = tmp;
	return false;
}

bool found(int number, Tree *tree)
{
	return found(number, tree->root);
}

void printABC(Node *tree)
{
	if (tree == nullptr)
	{
		printf(" null ");
		return;
	}
	printf("(");
	printf(" %d", tree->value);
	printABC(tree->left);
	printABC(tree->right);
	printf(")");
}

void printABC(Tree *tree)
{
	printABC(tree->root);
}

unsigned char height(Node* p)
{
	return p ? p->height : 0;
}

int balanceFactor(Node* p)
{
	return height(p->right) - height(p->left);
}

void fixHeight(Node* p)
{
	unsigned char hl = height(p->left);
	unsigned char hr = height(p->right);
	p->height = (hl > hr ? hl : hr) + 1;
}

Node* rotateRight(Node* p) 
{
	Node* q = p->left;
	p->left = q->right;
	q->right = p;
	fixHeight(p);
	fixHeight(q);
	return q;
}

Node* rotateLeft(Node* q) 
{
	Node* p = q->right;
	q->right = p->left;
	p->left = q;
	fixHeight(q);
	fixHeight(p);
	return p;
}

Node* balance(Node* p)
{
	fixHeight(p);
	if (balanceFactor(p) >= 1)
	{
		if (balanceFactor(p->right) < 0)
			p->right = rotateRight(p->right);
		return rotateLeft(p);
	}
	if (balanceFactor(p) == -1)
	{
		if (balanceFactor(p->left) > 0)
			p->left = rotateLeft(p->left);
		return rotateRight(p);
	}
	return p; 
}

Node* findMinimum(Node* p) 
{
	return p->left ? findMinimum(p->left) : p;
}

Node* removeMinimum(Node* p) 
{
	if( p->left==0 )
		return p->right;
	p->left = removeMinimum(p->left);
	return balance(p);
}

void remove(Node *&node, int number) 
{
	
	if (!node) 
		return;
	if (number < node->value)
		remove(node->left, number);
	else if (number > node->value)
		remove(node->right, number);	
		
	if (number == node->value)
	{	
		
		Node* q = node->left;
		Node* r = node->right;
		delete node;
		if (!r)
		{
			node = q;
			return;
		}
		Node* min = findMinimum(r);
		min->right = removeMinimum(r);
		min->left = q;
		node = balance(min);
		return;
	}
	node = balance(node);
	return;
}

void remove(Tree *&tree, int number) 
{
	remove(tree->root, number);
}

void deleteTree(Node *node)
{
	if (node)
	{
		deleteTree(node->left);
		deleteTree(node->right);
		delete node;
	}
}

void deleteTree(Tree *tree)
{
	deleteTree(tree->root);
	delete tree;
}
