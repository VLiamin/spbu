#include <stdio.h>
#include "head1.h"

using namespace std;

const int lengthArray = 100;

int searchTokenEnd(char *string, int i); 

int main(int argc, char *argv[])
{
	
	Tree *tree = createTree();
	FILE *f = fopen("text7_3.txt", "r");
	char string[lengthArray];
	fgets(string, lengthArray, f);
	push(tree, string, 0);
	printf("Expression: ");
	print(tree);
	printf("\n");
	printf("Value: %d", count(tree));
	fclose(f);
	return 0;
}

int searchTokenEnd(char *string, int i) 
{
	int sum = 0;
	if (string[i] == '(') 
	{
		sum++;
		i++;
		while (sum != 0) 
		{
			if (string[i] == '(')
				sum++;
			else if (string[i] == ')')
				sum--;
			i++;
		}
		while (string[i] == ' ')
		{
			i++;
		}
	} 
	else 
	{
		i++;
		while (string[i] == ' ')
		{
			i++;
		}
	}

	return i;
}
