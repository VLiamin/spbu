#include <stdio.h>
#include "head.h"

using namespace std;

Tree *createTree()
{
	return new Tree {nullptr};
}

void push(int number, Node *&node)
{
	if ((node != nullptr) && (number == node->value))
		return;
	if (node == nullptr)                   
	{
		node = new Node;      
		node->value = number;                
		node->left = nullptr;
		node->right = nullptr;                                
	}
	else 
	{
		if (number < node->value) 
			push(number, node->left); 
		else push(number, node->right); 
	}    
}

void push(int number, Tree *&tree)
{
	push(number, tree->root);
}

void printDecreasing(Node *node)
{
	if (node == nullptr) 
		return;                  
	else 
	{
		printDecreasing(node->right);                  
		printf(" %d", node->value);            
	}
	printDecreasing(node->left);                       
}

void printDecreasing(Tree *tree)
{
	printDecreasing(tree->root);
}

void printIncreasing(Node *node)
{
	if (node == nullptr) 
		return;                  
	else 
	{
		printIncreasing(node->left);                   
		printf(" %d", node->value);            
	}
	printIncreasing(node->right);                       
}

void printIncreasing(Tree *tree)
{
	printIncreasing(tree->root);
}

void remove(int number, Node *&node)
{
    if (node == nullptr)
    	  return;
	if (number == node->value)
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
	else if (number < node->value)
		remove(number, node->left);
	else
	{
		remove(number, node->right);
	}
	return;
}

void remove(int number, Tree *tree)
{
	remove(number, tree->root);
}


bool found(int number, Node *node)
{   
	Node *tmp = node;         
	while (node != nullptr)
	{
		if (number > node->value)
			node = node->right;
		else if (number < node->value)
			node = node->left;
		else
		{
			node = tmp;
			return true;
		}
	}
	node = tmp;
	return false;
}

bool found(int number, Tree *tree)
{
	return found(number, tree->root);
}

void printABC(Node *node)
{
	if (node == nullptr)
	{
		printf(" null ");
		return;
	}
	printf("(");
	printf(" %d", node->value);
	printABC(node->left);
	printABC(node->right);
	printf(")");
}

void printABC(Tree *tree)
{
	printABC(tree->root);
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

