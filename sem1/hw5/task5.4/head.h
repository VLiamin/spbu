#ifndef head_H
#define head_H

struct Stack
{
	char value;                                              
	Stack *Next;
	Stack *Head;                                   
};

Stack* add(char number, Stack *Element);

char pop(Stack* Element);

#endif
