#include <stdio.h>
const int lengthArray = 10000;
int reverse(int res);
int iterative(int rate);
	
main()
{
	int number = 0;
	printf("number = ");
	scanf("%d", &number);
	int rec = reverse(number);
	int ite = iterative(number);
	printf("result recurse = %d\n", rec);
	printf("result iterative = %d", ite);
	return 0;
}
 
 int reverse(int res)
{
	if (res > 2)
		return reverse(res - 1) + reverse(res - 2);
	else return 1;
}
 
 int iterative(int rate)
{
	int i = 0;
	int fib[lengthArray];
	fib[0] = 1;
	fib[1] = 1;	
	for (i = 2; i < rate; i++)
	{
		fib[i] = fib[i - 1] + fib[i - 2];	
	}
	return fib[i - 1];
}
