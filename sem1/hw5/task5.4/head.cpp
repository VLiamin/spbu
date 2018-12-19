#include <stdio.h>
#include "head.h"

Stack *createStack()
{
	return new Stack {nullptr};
}

void add(char number, StackElement *&element)
{
	StackElement *temp = new StackElement;                              
	temp->value = number;                                      
	temp->next = element;                          
	element = temp; 
}

void add(char number, Stack *&stack)
{
	add(number, stack->head);
}

char pop(StackElement *&element)
{
	StackElement *temp = element->next;
	char number = element->value;               
	delete element;                                
	element = temp;
	return number;
}

char pop(Stack *stack)
{
	return pop(stack->head);
}

void deleteStack(Stack *stack)
{
	delete stack;
}