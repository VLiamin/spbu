#include <stdio.h>
#include "head.h"

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
	return p?p->height:0;
}

int bfactor(Node* p)
{
	return height(p->right) - height(p->left);
}

void fixheight(Node* p)
{
	unsigned char hl = height(p->left);
	unsigned char hr = height(p->right);
	p->height = (hl>hr?hl:hr)+1;
}

Node* rotateright(Node* p) 
{
	Node* q = p->left;
	p->left = q->right;
	q->right = p;
	fixheight(p);
	fixheight(q);
	return q;
}

Node* rotateleft(Node* q) 
{
	Node* p = q->right;
	q->right = p->left;
	p->left = q;
	fixheight(q);
	fixheight(p);
	return p;
}

Node* balance(Node* p)
{
	fixheight(p);
	if (bfactor(p) >= 1)
	{
		if (bfactor(p->right) < 0)
			p->right = rotateright(p->right);
		return rotateleft(p);
	}
	if (bfactor(p) == -1)
	{
		if (bfactor(p->left) > 0)
			p->left = rotateleft(p->left);
		return rotateright(p);
	}
	return p; 
}

Node* findmin(Node* p) 
{
	return p->left?findmin(p->left):p;
}

Node* removemin(Node* p) 
{
	if( p->left==0 )
		return p->right;
	p->left = removemin(p->left);
	return balance(p);
}

void remove(Node *&node, int number) 
{
	if (!node) 
		return;
	if ( number < node->value )
		remove(node->left, number);
	else if (number > node->value)
		remove(node->right, number);
	else  
	{
	Node* tmp = nullptr;
		if (node->right == nullptr)
			tmp = node->left;
		else 
		{
			Node* ptr = node->right;
			if (ptr->left == nullptr)
			{
				ptr->left = node->left;
				tmp = ptr;
			} 
			else 
			{
				Node* pmin = ptr->left;
				while (pmin->left != nullptr)
				{
					ptr  = pmin;
					pmin = ptr->left;
				}
 				ptr->left = pmin->right;
				pmin->left = node->left;
				pmin->right = node->right;
				tmp = pmin;
			}
		}
		delete node;
		node = tmp;
		return;
	}
	balance(node);
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
