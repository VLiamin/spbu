#include <stdio.h>
#include "head.h"
main()
{
	node *tree = nullptr;
	printf("0 - exit\n");
	printf("1 - delete number\n");
	printf("2 - insert\n");
	printf("3 - found\n");
	printf("4 - print increasing\n");
	printf("5 - print decreasing\n");
	printf("6 - print (a, b, c)\n");
	bool isExit = false;
	int i = 0;
	int number = 0;
	bool seek = false;
	while (!isExit)
	{
		printf("Your number: ");
		scanf("%d", &i);
		switch(i)
		{
			case 0:
				isExit = true;
				break;
			case 1:
				printf("Your element: ");
				scanf("%d", &number);
				add(number, tree);
				break;
			case 2:
				printf("Your element: ");
				scanf("%d", &number);
				push(number, &tree);
				break;
			case 3:
				printf("Your element: ");
				scanf("%d", &number);
				seek = found(number, tree);
				if (seek)
					printf("YES\n");
				else
					printf("NO\n");
				break;
			case 4:
				printIn(tree);
				printf("\n");
				break;
			case 5:
				printDe(tree);
				printf("\n");
				break;
			case 6:
				printABC(tree);
				printf("\n");
				break;
		}
	}
	return 0;
}

