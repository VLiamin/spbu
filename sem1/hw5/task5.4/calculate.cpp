#include "calculate.h"
#include "head.h"

int countExpression(char *string)
{
	Stack *stack = createStack();
	
	int meaning = 0;
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
	
	deleteStack(stack);
	
	return meaning;
}

