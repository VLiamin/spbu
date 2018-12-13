#include "head.h"
#include <stdio.h>

Tree *createTree()
{
	return new Tree {nullptr};
}

void push(Node *&tree, char *string, int i) 
{
	if (string[i] == '(') 
	{
		tree = new Node;
		tree->value = string[i + 1];
		tree->right = nullptr;
		tree->left = nullptr;
		int firstTokenStart = i + 2;
		int secondTokenStart = searchTokenEnd(string, firstTokenStart);
		push(tree->left, string, firstTokenStart);
		push(tree->right, string, secondTokenStart);
		return;
	} 
	else 
	{
		tree = new Node;
		tree->value = string[i];
		tree->left = nullptr;
		tree->right = nullptr;
		return;
	}
}

void push(Tree *&tree, char *string, int i)
{
	push(tree->roof, string, i); 
}

void print(Node *tree) 
{
	if (tree == nullptr)
		return;
	if (tree->left != nullptr)
		printf("(");
	print(tree->left);
	printf("%c", tree->value);
	print(tree->right);
	if (tree->left != nullptr)
		printf(")");
}

void print(Tree *tree) 
{
	print(tree->roof);
}

int count(Node *tree) 
{
	if (tree->left == nullptr) 
	{
		return tree->value - '0';
	} 
		
	switch (tree->value) 
	{
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

int count(Tree *tree)
{
	return count(tree->roof);
}
