#include <stdio.h>
int main()
{
	char s[8];
	char s1[2];
	printf("s = ");
	scanf("%s", s);
	printf("s1 = ");
	scanf("%s", s1);
	int sum = 0;
	bool isEntrance = true;
	for (int i = 0; i < 8; i++)
	{
		isEntrance = false;
		if (s[i] == s1[0])
			isEntrance = true;
			for (int j = 0; j < 2; j++)
			{
				if (s[i + j] != s[j])
					isEntrance = false;  
			}
		if (isEntrance)
			sum++;
	}
	printf("sum = %d", sum);
	return 0;
}

