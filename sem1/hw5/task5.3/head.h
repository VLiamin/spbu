#ifndef head_H
#define head_H

struct StackElement
{
	char value;
	StackElement *next;
};

struct Stack
{
	StackElement *head;
};

Stack *createStack();
void add(char number, Stack *&stack);
char pop(Stack *stack);
void deleteStack(Stack *stack);

#endif
