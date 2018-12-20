#include <stdio.h>
#include "head.h"

using namespace std;

int main()
{
	printf("0 - Exit\n");
	printf("1 - Creature\n");
	printf("2 - Delete\n");
	printf("3 - Clone\n");
	printf("4 - Concatenation\n");
	printf("5 - Equal\n");
	printf("6 - Length\n");
	printf("7 - Check for emptiness\n");
	printf("8 - Substring allocation\n");
	printf("9 - Convent to *char\n");
	int i = 0;
	bool create = false;
	String *string = nullptr;
	bool getAway = false;
	while (!getAway)
	{
		printf("Your number: ");
		scanf("%d", &i);
		switch (i)
		{
			case 0:
				getAway = true;
				break;
			case 1:
				create = true;
				string = createString();
				break;
			case 2:
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				deleteString(string);
				create = false;
				break;
			case 3:
			{
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				printf("Result: ");
				print(string);
				break;
			}
			case 4:
			{
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				int length = 0;
				printf("Length string: ");
				scanf("%d", &length);
				char *newString = new char[length];	
				printf("Your string: ");
				scanf("%s", newString);
				i = 0;
				add(string, newString, i);
				delete [] newString;
				break;
			}
			case 5:
			{
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				int length = 0;
				printf("Length string: ");
				scanf("%d", &length);
				printf("Your string: ");
				char *example = new char[length];
				scanf("%s", example);
				if (compare(string, example))
					printf("Result: YES\n");
				else
					printf("Result: NO\n");
				delete [] example;
				break;
			}		
			case 6:
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				printf("Length: %d\n", findTheLength(string));
				break;
			case 7:
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				if (CheckForEmptiness(string))
					printf("Empty\n");
				else
					printf("Not empty\n");
					
				break;
			case 8:
			{
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				int firstIndex = 0;
				int lastIndex = 0;
				printf("First index: ");
				scanf("%d", &firstIndex);
				printf("Last index: ");
				scanf("%d", &lastIndex);
				substringAllocation(string, firstIndex, lastIndex);
				break;
					
			}
			case 9:
			{
				if (!create)
				{
					printf("You forgot to create string!\n");
					break;
				}
				char* stringChar = convertToChar(string);
				printf("%s\n", stringChar);
				delete [] stringChar;
				break;
					
			}			
		}
	}

	return 0;
}
