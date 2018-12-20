#pragma once

struct Symbol
{
	Symbol *next;
	char symbol;
};

struct String
{
	Symbol *first;
};

String *createString();
void deleteString(String *string);
String *clone(String *string);
void print(String *string);
void add(String *&string, char *newString, int &i);
char* allocateMemory(char* string, int i);
bool compare(String *string, char *example);
int findTheLength(String *string);
bool CheckForEmptiness(String *string);
void substringAllocation(String *string, int firstIndex, int lastIndex);
char *convertToChar(String *string);
