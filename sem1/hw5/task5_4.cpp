#include <stdio.h>
int main()
{
	char a = '0';
	char b = '0';
	char meaning = 0;
	struct Stack
	{
		char value;                                              
		Stack *Next;
		Stack *Head;                                   
	};	
	int size = 20;
	printf("Length expression: ");
	scanf("%d", &size);
	char* string = new char[size];
	printf("Your expression: ");
	scanf("%s", string);
	int i = 0;
	Stack *Element = new Stack;
	Element->Head = nullptr;
	while ((string[i] >= '0') && (string[i] <= '9'))
	{
		Stack *temp = new Stack;                              
		temp->value = string[i];                                      
		temp->Next = Element->Head;                          
		Element->Head = temp;  
		i++;
	}
	while (string[i] != '\0')
	{
		a =  Element->Head->value;
		Stack *temp = Element->Head->Next;               
		delete Element->Head;                                
		Element->Head = temp; 
		b =  Element->Head->value; 
		temp = Element->Head->Next;                
		delete Element->Head;                                
		Element->Head = temp; 
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
        	
		temp = new Stack;                              
		temp->value = meaning + '0';                                      
		temp->Next = Element->Head;                          
		Element->Head = temp; 
		i++;
	}
	printf("Result: %d", meaning);
	delete [] string;
	return 0;
}
