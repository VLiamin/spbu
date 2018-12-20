#include "head.h"
#include <stdio.h>

Tree *createTree()
{
	return new Tree {nullptr};
}

void push(Node *&node, char *string, int i) 
{
	if (string[i] == '(') 
	{
		node = new Node;
		i++;
		while (string[i] == ' ')
		{
			i++;
		}
		node->value = string[i];
		node->numeral = -1;
		node->right = nullptr;
		node->left = nullptr;
		i++;
		while (string[i] == ' ')
		{
			i++;
		}
		int firstTokenStart = i;
		int secondTokenStart = searchTokenEnd(string, firstTokenStart);
		push(node->left, string, firstTokenStart);
		push(node->right, string, secondTokenStart);
		return;
	} 
	else 
	{
		
		node = new Node;
		node->numeral= 0;
		node->value = 'b';
		while ((string[i] >= '0') && (string[i] <= '9'))
		{
			node->numeral = node->numeral * 10 + string[i] - '0';
			i++;
		}
		node->left = nullptr;
		node->right = nullptr;
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
	if (tree->value != 'b')
		printf(" %c ", tree->value);
	else 
		printf("%d", tree->numeral);
	print(tree->right);
	if (tree->left != nullptr)
	{
		printf(")");
	}
		
}

void print(Tree *tree) 
{
	print(tree->roof);
}

int count(Node *tree) 
{
	if (tree->left == nullptr) 
	{
		return tree->numeral;
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
