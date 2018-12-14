#include <stdio.h>
#include "head.h"
#include <fstream>

using namespace std;

int main()
{
	char numbers[length];
	FILE *f = fopen("D://спбгу/сем1/тест1/1.1/text2.txt", "r");
	List *list = createList();
	fgets(numbers, length, f);
    int i = 0;
    bool compare = true;
	while (numbers[i] != '\0')
	{
		if ((numbers[i] <= '9') && (numbers[i] >= '0'))
			push(list, numbers[i]);
		i++;	 	
		
	}
	for (int j = 0; j <= int(i / 2); j++)
	{
		if (check(list) == false)
			compare = false;
		if (!compare)
			printf("0");
	}
	
	if (compare == true)
		printf("TRUE");
	else
		printf("FALSE");
	return 0;
}
		
	
