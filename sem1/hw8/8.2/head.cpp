#include <stdio.h>
#include "head.h"

String *createString()
{
    return new String {nullptr};
}

void deleteString(Symbol *symbol)
{
	Symbol *tmp = symbol;
	while (symbol)
	{
		symbol = symbol->next;
		delete tmp;
		tmp = symbol;
	}
}

void deleteString(String *string)
{
	deleteString(string->first);
	delete string;
}

void print(Symbol *symbol)
{
	while (symbol)
	{
		printf("%c", symbol->symbol);
		symbol = symbol->next;
	}
	printf("\n");
}

void print(String *string)
{
	print(string->first);
}

void add(Symbol *&symbol, char *newString, int &i)
{
	
	if (symbol)
		add(symbol->next, newString, i);
	if (newString[i] != '\0')
	{
		symbol = new Symbol;
		symbol->next = nullptr;
		symbol->symbol = newString[i];
		i++;
		add(symbol->next, newString, i);
	}
}

void add(String *&string, char *newString, int &i)
{
	add(string->first, newString, i);
}

bool compare(Symbol *element, char *example)
{
	int i = 0;
	while (element)
	{
		if (element->symbol != example[i]) return false;
		i++;
		element = element->next;	
	}
	if (example[i] != '\0') return false; 
	return true;
}

bool compare(String *string, char *example)
{
	return compare(string->first, example);
}

int findTheLength(Symbol *element)
{
	int i = 0;
	while (element)
	{
		i++;
		element = element->next;
	}
	return i;
}

int findTheLength(String *string)
{
	return findTheLength(string->first);
}

bool CheckForEmptiness(String *string)
{
	if (string->first) return false;
	return true;
}

void substringAllocation(Symbol *element, int firstIndex, int lastIndex)
{
	int i = 0;
	while ((i < firstIndex) && (element))
	{
		i++;
		element = element->next;
	}
	while ((i <= lastIndex) && (element))
	{
		printf("%c", element->symbol);
		i++;
		element = element->next;
	}
	printf("\n");
}

void substringAllocation(String *string, int firstIndex, int lastIndex)
{
	substringAllocation(string->first, firstIndex, lastIndex);
}

char* convertToChar(Symbol *element, int length)
{
	int i = 0;
	char* stringChar = new char[length];
	for (i = 0; i < length; i++)
	{
		stringChar[i] = element->symbol;
		element = element->next;
	}
	stringChar[i] = '\0';
	return stringChar;
}

char* convertToChar(String* string)
{
	int length = findTheLength(string);
	return convertToChar(string->first, length);

}
