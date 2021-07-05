#include <stdio.h>
const int stringLength = 100;
main()
{
	char ptr[stringLength];
	int number = 0;
	int i = 0;
	FILE *f = fopen("text.txt", "r");
	if (f != NULL) 
	{ 
		while (fgets(ptr, stringLength, f))
		{
			if (*ptr == '\n')
				number++;
			i = 0;
			while (ptr[i] != '\n')
			{
				if ((ptr[i] != '\t') && (ptr[i] != ' ') && (ptr[i] != '\n'))
				{
					break;
				}
				i++;
				if (ptr[i] == '\n')
					number++;
			}	
		}
	} 
	else 
		printf("not open");
	fclose(f);
	printf("number = %d", number);
	return 0;
}

