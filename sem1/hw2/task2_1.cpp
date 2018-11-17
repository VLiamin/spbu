#include <stdio.h>
int reverse(int res);
int iterative(int rate);
	
main()
{
	int number = 0;
	printf("number = ");
	scanf("%d", &number);
	int resultReverse = reverse(number);
	int resultIterative = iterative(number);
	printf("result reverse = %d\n", resultReverse);
	printf("result iterative = %d", resultIterative);
	return 0;
}
 
int reverse(int numeral)
{
	if (numeral > 2)
		return reverse(numeral - 1) + reverse(numeral - 2);
	else return 1;
}
 
int iterative(int numeral)
{
	int *fib = new int[numeral];
	int i = 0;
	fib[0] = 1;
	fib[1] = 1;
	for (i = 2; i < numeral; i++)
	{
		fib[i] = fib[i - 1] + fib[i - 2];	
	}
	i = fib[i - 1];
	delete [] fib;
	return i;
}
