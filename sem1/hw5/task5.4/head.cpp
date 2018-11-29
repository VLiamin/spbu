#include <stdio.h>
#include "head.h"

Stack* add(char number, Stack *Element)
{
	Stack *temp = new Stack;                              
	temp->value = number;                                      
	temp->Next = Element->Head;                          
	Element->Head = temp; 
}

char pop(Stack* Element)
{
	char number =  Element->Head->value;
	Stack *temp = Element->Head->Next;               
	delete Element->Head;                                
	Element->Head = temp; 
	return number;
}
