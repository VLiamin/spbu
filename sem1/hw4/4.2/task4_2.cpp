#include <stdio.h>
#include "head.h"

using namespace std;

bool compare(char strText[length], char strYour[length]);

int main(int argc, char *argv[])
{
	FILE *f = fopen("text2.txt", "a+");
	List *list = createList();
	int i = 0;
	char forename[length];
	char phone[length];
	char last[length];
	char facts[length];
	char ptr[length];
	while (fgets(ptr, length, f))
	{
		push(list, ptr);
	} 
	fseek(f, 0L, SEEK_SET);
	printf("0 - exit\n");
	printf("1 - Add a note\n");
	printf("2 - find a phone by name\n");
	printf("3 - find a name by phone\n");
	printf("4 - save current data to file\n");
	bool isExit = false;
	while (!isExit) 
	{
		printf("Your number: ");
		scanf("%d", &i);
		switch (i) 
		{
			case 0:
				isExit = true;
				break;
			case 1:
				printf("Name: ");
				scanf("%s", forename);
				printf("Telephone number: ");
				scanf("%s", phone);
				push(list, forename);
				push(list, phone);
				break;
			case 2:
				printf("Name ");
				scanf("%s", forename);
				while (fgets(ptr, length, f)) 
				{
					if (compare(ptr, forename)) 
					{
						fgets(ptr, length, f);
						printf("%s", ptr);
						break;
					}
				}
				fseek(f, 0L, SEEK_SET);

				break;
			case 3:
				printf("Telephone number: ");
				scanf("%s", phone);
				while (fgets(ptr, length, f)) 
				{
					if (compare(ptr, phone)) 
					{
						printf("%s", last);
						break;
					}
					for (int j = 0; j < length - 1; j++) 
					{
						last[j] = ptr[j];
					}
				}
				fseek(f, 0L, SEEK_SET);

				break;
			case 4:
				int i = 0;
				while (fgets(ptr, length, f)) 
				{
					i = 0;
					while (ptr[i] != '\0')
					{
						phone[i] = ptr[i];
						i++;
					}
					while (i < 15)
					{
						phone[i] = '\0';
						i++;
					}
				}
				save(list, phone, f);
				fseek(f, 0L, SEEK_SET);
				break;
		}
	}
	fclose(f);
	return 0;
}

bool compare(char strText[length], char strYour[length]) 
{
	int sum = 0;
	int l = 0;
	while (strText[l] != '\n') 
	{
		sum++;
		l++;
	}
	
	for (l = 0; l < sum; l++) 
	{
		if (strText[l] != strYour[l]) 
		{
			return false;
		}
	}
	return true;
}
