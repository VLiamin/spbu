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
	printf("stringResult: ");
	for (i = 0; i < lengthString; i++)
		printf("%c", stringResult[i]);
	delete [] string;
	delete plus->headPl;
	delete plus;
	delete multiplication->headMu;
	delete multiplication;
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
