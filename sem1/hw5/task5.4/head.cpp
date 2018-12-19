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

void deleteStack(StackElement *element)
{
	StackElement *tmp = element;
	while (element)
	{
		element = element->next;
		delete tmp;
		tmp = element;
	}
}

void deleteStack(Stack *stack)
{
	deleteStack(stack->head);
	delete stack;
}

void count(Stack *stack, char *string, int &meaning)
{
	int i = 0;
	char a = '0';
	char b = '0';
	
	while (string[i] != '\n')
	{
		while ((string[i] >= '0') && (string[i] <= '9'))
		{
			add(string[i], stack);
			i++;
		}

		while ((string[i] != '\n') && ((string[i] < '0') || (string[i] > '9')))
		{
			a =  pop(stack); 
			b =  pop(stack);
			a = a - '0';
			b = b - '0';
        
			if (string[i] == '-')
				meaning = b - a;
			else if (string[i] == '+')
				meaning = b + a;
			else if (string[i] == '*')
				meaning = b * a;
			else
				meaning = int(b / a);
        	
			add(meaning + '0', stack);

			i++;
		}
	}
}
