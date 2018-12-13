#include <stdio.h>
#include "head.h"

Stack *createStack()
{
	return new Stack {nullptr};
}

void add(char x, StackElement *&element)                          
{
    StackElement *temp = new StackElement;                             
    temp->value = x;                                        
    temp->next = element;                          
    element = temp; 
	                               
}

void add(char x, Stack *&stack)
{
	add(x, stack->head);
}

char pop(StackElement *&element)
{
	if (element != nullptr)                        
	{
		char value = element->value;
		StackElement *temp = element->next;                    
		delete element;                                
		element = temp;  
		return value;                              
	}
	return 'b';
}

char pop(Stack *element)
{
	return pop(element->head);
}

bool check(StackElement *element)
{
	if (element != nullptr)
	{
		return true;
	}
	return false;
}

bool check(Stack *stack)
{
	return check(stack->head);
}

bool plus(StackElement *element)
{
	if ((element->value == '-') || (element->value == '+'))
		return true;
	return false;
}

bool plus(Stack *stack)
{
	return plus(stack->head);
}

void deleteStack(Stack *stack)
{
	delete stack;
}
