#include <stdio.h>
main()
{
	int sum = 0;
	int i = 0;
	printf("string = ");
	char s[20];
	scanf("%s", s);
	bool isBrackets = true;
	for (i = 0; i < 20; i++) 
	{
		if (s[i] == '(' )
			sum++;
		if (s[i] == ')' )
			sum--; 
		if (sum < 0) 
			isBrackets = false;
	}
	if (sum != 0) 
		isBrackets = false;
	if (isBrackets)
		printf("YES");
	else 
		printf("NO");
	return 0;
}

