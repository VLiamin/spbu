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
void add(char x, Stack *&element);
char pop(Stack *stack);
bool check(Stack *stack);
bool plus(Stack *stack);
void deleteStack(Stack *stack);
int countParentheses(char *expression);
void tinkeringFromInfixToPostfix(Stack *stack, char *expression, char *expressionResult);
void count(Stack *stack, char *string, int &meaning, int lengthString);

#endif
