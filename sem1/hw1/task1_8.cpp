#include <stdio.h>
int countRecursively(int n);
int countIteratively(int rate);
int main()
{
	int n = 0;
	printf("number: ");
	scanf("%d", &n);
	int resre =  countRecursively(n);
	int resite = countIteratively(n);
	printf("result recurse = %d\n", resre);
	printf("result iterative = %d", resite);
	return 0;
}
int countRecursively(int num)
{
	if (num > 1)
		return countRecursively(num - 1) * num;
	else 
		return 1;
	
}
int countIteratively(int rate)
{
	int fact = 1;
	for (int i = rate; i > 1; i--)
	{
		fact = fact * i;	
	}
	return fact;
}

