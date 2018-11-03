#include <stdio.h>
main()
{
	char s[20];
	printf("string = ");
	scanf("%s", s);
	int sum = 0;
	bool isPalindrome = true;
	for (int i = 0; i < 20; i++)
	{
		if (s[i] == '\0')
		{
			sum = i;
			break;
		}
	}
	for (int i = 0; i < int(sum / 2); i++)
	{
		if (s[i] != s[sum - 1 - i])	
		{
			isPalindrome = false;
		}
	}
	if (isPalindrome) 
	{
		printf("YES");
	}
	else
	{
		printf("NO");	
	}
}

