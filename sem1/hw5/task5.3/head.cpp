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
	if (element != nullptr) return true;
	
	return false;
}

bool check(Stack *stack)
{
	return check(stack->head);
}

bool plus(StackElement *element)
{
	if (element == nullptr)	return false;
	if ((element->value == '-') || (element->value == '+')) return true;
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

int countParentheses(char *expression)
{
	int parentheses = 0;
	int i = 0;
	while (expression[i] != '\n')
	{
		if (expression[i] == '(')
		{
			parentheses++;
		}
		i++;
	}
	int lengthString = i - parentheses * 2;
	return lengthString;
}

void seeParentheses(Stack *stack, char *expression, int &i, char &symbol, int &parentheses, char *expressionResult, int &number)
{
	if (expression[i] == '(')
	{
		parentheses++;
		if (symbol != 'b')
		{
			add(symbol, stack); 
			symbol = 'b';
		}
		i++;

	}
	if (expression[i] == ')')
	{
		parentheses--;
		if (symbol != 'b')
		{
			expressionResult[number] = symbol;
			number++;
		}
		
		if (plus(stack))
		{
			symbol = pop(stack);
			i++;
			return;
		}

		if (check(stack))
		{
			expressionResult[number] = pop(stack);
			number++;
		}
		i++;
	}
}

void swapSymbols(Stack *stack, char *expression, int &i, char &symbol, int &parentheses, char *expressionResult, int &number)
{
	if ((int(expression[i]) >= '0') && (int(expression[i]) <= '9'))
	{
		expressionResult[number] = expression[i];
		i++;
		number++;
	}
		
	if ((expression[i] == '*') || (expression[i] == '/'))
	{
		if (expression[i + 1] != '(')
		{
		
			expressionResult[number] = expression[i + 1];
			expressionResult[number + 1] = expression[i];
			number += 2;
			i += 2;
		}
		else
		{
			add(expression[i], stack); 
			i++;
		}
	}
	if ((expression[i] == '-') || (expression[i] == '+'))
	{
		if (symbol != 'b')
		{
			expressionResult[number] = symbol;
			number++;
		}
		symbol = expression[i];	
		i++;
	}
}

void tinkeringFromInfixToPostfix(Stack *stack, char *expression, char *expressionResult)
{
	int i = 0;
	int number = 0;
	int parentheses = 0;
	char symbol= 'b';
   
	while (expression[i] != '\n')
	{
		seeParentheses(stack, expression, i, symbol, parentheses, expressionResult, number);
		
		swapSymbols(stack, expression, i, symbol, parentheses, expressionResult, number);
			
	}
	
	if ((symbol == '-') || (symbol == '+'))
	{
		expressionResult[number] = symbol;
		symbol = 'b';
		number++;
	}
}
