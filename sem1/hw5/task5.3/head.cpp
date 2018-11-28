#include <stdio.h>
#include "head.h"

void AddPlus(char x, StackPlus *&plus)                          
{
    StackPlus *temp = new StackPlus;                             
    temp->valuePlus = x;                                        
    temp->nextPlus = plus->headPlus;                          
    plus->headPlus = temp;                                
}

void AddMultiplication(char x, StackMultiplication *&multiplication)                          
{
    StackMultiplication *temp = new StackMultiplication;                             
    temp->valueMultiplication = x;                                        
    temp->nextMultiplication = multiplication->headMultiplication;                          
    multiplication->headMultiplication = temp;                                
}

char PopPlus(StackPlus *plus)
{
	if (plus->headPlus != nullptr)                        
	{
		char value = plus->headPlus->valuePlus;
		StackPlus *temp = plus->headPlus->nextPlus;                    
		delete plus->headPlus;                                
		plus->headPlus = temp;  
		return value;                              
	}
	return 'b';
}

char PopMultiplication(StackMultiplication *multiplication)
{
	if (multiplication->headMultiplication != nullptr)                        
	{
		char value = multiplication->headMultiplication->valueMultiplication;
		StackMultiplication *temp = multiplication->headMultiplication->nextMultiplication;                    
		delete multiplication->headMultiplication;                                
		multiplication->headMultiplication = temp;  
		return value;                              
	}
}
