#include <stdio.h>
#include "tree.h"

using namespace std;

Tree *createTree()
{
	return new Tree {nullptr};
}

void build(List* list, Node *&node)
{
	node = new Node;
	node->symbol = '*';
	Node *substitute = node;
	Node *substitute2 = node;
	node->right = nullptr;
	node->left = nullptr;
	int number = 0;
	if (check(list, number))
	{
		node->left = new Node;
		node->left->symbol = pop(list, number);
		node->left->value = number;
		node->left->left = nullptr;
		node->left->right = nullptr;
	}
	else
		return;

	if (check(list, number))
	{
		node->right = new Node;	
		node->right->left = nullptr;
		node->right->right = nullptr;	
		node->right->symbol = pop(list, number);
		node->right->value = number;
	}
	else 
		return;	
		
	node->value = node->right->value + node->left->value;
	
	while (check(list, number))
	{
		if ((list->first->next != nullptr) && (list->first->next->number < node->value))
		{

			bool go = false;
			Node *tmp = new Node;
			tmp->left = new Node;
			tmp->right = new Node;
			tmp->symbol = '*';
			tmp->left->symbol = pop(list, number);
			tmp->left->value = number;
			tmp->right->symbol = pop(list, number);
			tmp->right->value = number;
			tmp->value = tmp->right->value + tmp->left->value;
			tmp->left->left = nullptr;
			tmp->left->right = nullptr;
			tmp->right->left = nullptr;
			tmp->right->right = nullptr;
			substitute = node;
			while ((node->left->value < node->right->value) && (node->left->left != nullptr) && (node->right->left != nullptr))
			{
				go = true;
				substitute2 = node;
				node = node->right;	
			}
			
			if (go)
			{
				Node *newNode = new Node;
				substitute2->right = newNode;
				newNode->left = node;
				newNode->right = tmp;
				newNode->symbol = '*';
				newNode->value = tmp->value + node->value;
				node = substitute;
			}
			else
			{
				Node *newNode = new Node;
				newNode->right = tmp;
				newNode->left = node;
				newNode->value = tmp->value + node->value;
				node = newNode;
			}
			node->symbol = '*';
		}
		else
		{
			
			Node *newNode = new Node;
			newNode->left = node;
			newNode->right = new Node;
			newNode->right->symbol = pop(list, number);
			newNode->right->right = nullptr;
			newNode->right->left = nullptr;
			newNode->right->value = number;
			newNode->symbol = '*';
			newNode->value = node->value + number;
			node = newNode;
			
		}
	}
	return;
}

void build(List *list, Tree *&tree)
{
	build(list, tree->root);
}

void printABC(Node *node)
{
	if (node == nullptr)
	{
		printf(" null ");
		return;
	}
	
	printf("(");
	printf(" %c", node->symbol);
	printABC(node->left);
	printABC(node->right);
	printf(")");
}

void printABC(Tree *tree)
{
	printABC(tree->root);
}

void coding(Node *node, List *list, long number)
{
	if (node == nullptr)
	{
		delete node;
		return;
	}
	if (node->symbol != '*')
		push(list, node->symbol, number);
	coding(node->left, list, number * 10 + 1);
	coding(node->right, list, number * 10 + 0);
	
}


void coding(Tree *tree, List *list, long number)
{
	coding(tree->root, list, number);
	delete tree;
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

