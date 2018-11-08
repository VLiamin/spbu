#include <stdio.h>

struct StackPl
{
	char valuePl;
	StackPl *nextPl;
	StackPl *headPl;
};

struct StackMu
{
	char valueMu;
	StackMu *nextMu;
	StackMu *headMu;
};

void AddPl(char x, StackPl *&plus);

void AddMu(char x, StackMu *&multiplication);

char PopPl(StackPl *plus);

char PopMu(StackMu *multiplication);

void count(char *string);

main()
{
	int length = 0;
	printf("Length expression: ");
	scanf("%d", &length);
	printf("Your expression: ");
	char *string = new char[length];
	int number = 0;
	scanf("%s", string);
	int i = 0;
	int parentheses = 0;
	
	StackPl *plus = new StackPl;
	plus->headPl = nullptr;
	
	StackMu *multiplication = new StackMu;
	multiplication->headMu = nullptr;
	
	while (string[i] != '\0')
	{
		i++;
		if (string[i] == '(')
		{
			parentheses++;
		}
	}
	int lengthString = i - parentheses * 2;
	char symbol= 'b';
	i = 0;
	parentheses = 0;
	char stringResult[lengthString - 1];
   
	while (string[i] != '\0')
	{
    	if (string[i] == '(')
		{
			parentheses++;
			if (symbol != 'b')
			{
				AddPl(symbol, plus); 
				symbol = 'b';
			}
			i++;
		}
		
		if (string[i] == ')')
		{
			parentheses--;
			if (symbol != 'b')
			{
				stringResult[number] = symbol;
				number++;
			}
			symbol = PopPl(plus);
			if (multiplication->headMu != nullptr)
			{
				stringResult[number] = PopMu(multiplication);
				number++;
			}
			i++;
		}
    	
		if ((int(string[i]) >= '0') && (int(string[i]) <= '9'))
		{
			stringResult[number] = string[i];
			i++;
			number++;
		}
		if ((string[i] == '*') || (string[i] == '/'))
		{
			if (string[i + 1] != '(')
			{
			
				stringResult[number] = string[i + 1];
				stringResult[number + 1] = string[i];
				number += 2;
				i += 2;
			}
			else
			{
				AddMu(string[i], multiplication); 
				i++;
			}
		}
		if ((string[i] == '-') || (string[i] == '+'))
		{
			if (symbol != 'b')
			{
				stringResult[number] = symbol;
				number++;
			}
			symbol = string[i];	
			i++;
		}
	}
	if ((symbol == '-') || (symbol == '+'))
	{
		stringResult[number] = symbol;
		symbol = 'b';
		number++;
	}
	
	delete [] string;
	delete plus->headPl;
	delete plus;
	delete multiplication->headMu;
	delete multiplication;
	
	count(stringResult);
	
	return 0;
}

void AddPl(char x, StackPl *&plus)                          
{
    StackPl *temp = new StackPl;                             
    temp->valuePl = x;                                        
    temp->nextPl = plus->headPl;                          
    plus->headPl = temp;                                
}

void AddMu(char x, StackMu *&multiplication)                          
{
    StackMu *temp = new StackMu;                             
    temp->valueMu = x;                                        
    temp->nextMu = multiplication->headMu;                          
    multiplication->headMu = temp;                                
}

char PopPl(StackPl *plus)
{
	if (plus->headPl != nullptr)                        
	{
		char value = plus->headPl->valuePl;
		StackPl *temp = plus->headPl->nextPl;                    
		delete plus->headPl;                                
		plus->headPl = temp;  
		return value;                              
	}
	return 'b';
}

char PopMu(StackMu *multiplication)
{
	if (multiplication->headMu != nullptr)                        
	{
		char value = multiplication->headMu->valueMu;
		StackMu *temp = multiplication->headMu->nextMu;                    
		delete multiplication->headMu;                                
		multiplication->headMu = temp;  
		return value;                              
	}
}

void count(char string[])
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

	int i = 0;
	Stack *Element = new Stack;
	Element->Head = nullptr;
	while (string[i] != '\0')
	{
		while ((string[i] >= '0') && (string[i] <= '9'))
		{
			Stack *temp = new Stack;                              
			temp->value = string[i];                                      
			temp->Next = Element->Head;                          
			Element->Head = temp;
			i++;  
		}
	
	
		while (((string[i] <= '0') || (string[i] >= '9')) && (string[i] != '\0'))
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
	}
	printf("Result: %d", meaning);
	delete [] string;
	delete Element;
}

