#include <malloc.h>
#include <cstddef>
#include <stdio.h>
#include "head.h"

void push(int number, node **tree)
{
    if ((*tree) == nullptr)                   
    {
        (*tree) = new node;      
        (*tree)->value = number;                
        (*tree)->left = nullptr;
		(*tree)->right = nullptr;                                
    }
    else 
    {
    	if (number < (*tree)->value) 
			push(number, &(*tree)->left); 
        else push(number, &(*tree)->right); 
	}    
}
void printDe(node *tree)
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

void printIn(node *tree)
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

node* add(int number, node *tree)
{
    if (tree == nullptr)
        return tree;
    if (number == tree->value)
	{
        node* tmp = nullptr;
        if (tree->right == nullptr)
            tmp = tree->left;
        else 
		{
            node* ptr = tree->right;
            if (ptr->left == nullptr)
			{
                ptr->left = tree->left;
                tmp = ptr;
            } 
			else 
			{
                node* pmin = ptr->left;
                while (pmin->left != nullptr)
				{
                    ptr  = pmin;
                    pmin = ptr->left;
                }
                ptr->left   = pmin->right;
                pmin->left  = tree->left;
                pmin->right = tree->right;
                tmp = pmin;
            }
        }
        delete tree;
        return tmp;
    } 
	else
	if (number < tree->value)
        tree->left = add(number, tree->left);
    else
    {
    	tree->right = add(number, tree->right);
	}
    return tree;
}

bool found(int number, node *tree)
{   
	node *tmp = tree;         
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

void printABC(node *tree)
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
