#include <stdio.h>
#include "list.h"
#include "tree.h"
const int length = 100;

int main()
{
	FILE *f = fopen("text.txt", "r");
	List *list = createList();
	char string[length];
	
	while (fgets(string, length, f))
	{

		int i = 0;
		while (string[i] != '\n')
		{
			push(list, string[i], 1);
			i++;
		}
	} 
	fseek(f, 0L, SEEK_SET);
	sort(list);
	Tree *tree = createTree();
	build(list, tree);
	printABC(tree);
	coding(tree, list, 0);
	printf("\n");
	
	while (fgets(string, length, f))
	{

		int i = 0;
		while (string[i] != '\n')
		{
			write(list, string[i]);
			i++;
		}
	} 
	deleteList(list);
	return 0;
}
