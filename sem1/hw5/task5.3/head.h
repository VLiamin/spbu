#ifndef head_H
#define head_H
struct StackPlus
{
	char valuePlus;
	StackPlus *nextPlus;
	StackPlus *headPlus;
};

struct StackMultiplication
{
	char valueMultiplication;
	StackMultiplication *nextMultiplication;
	StackMultiplication *headMultiplication;
};

void AddPlus(char x, StackPlus *&plus);

void AddMultiplication(char x, StackMultiplication *&multiplication);

char PopPlus(StackPlus *plus);

char PopMultiplication(StackMultiplication *multiplication);

#endif
