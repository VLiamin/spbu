#include <stdio.h>
int countRecursively(int number);
int countIteratively(int number);
	
main()
{
	int number = 0;
	printf("number = ");
	scanf("%d", &number);
	int resultRecursion = countRecursively(number);
	int resultIterative = countIteratively(number);
	printf("result recursion = %d\n", resultRecursion);
	printf("result iterative = %d", resultIterative);
	return 0;
}
 
int countRecursively(int number)
{
	if (number > 2)
		return countRecursively(number - 1) + countRecursively(number - 2);
	else return 1;
}
 
int countIteratively(int number)
{
	int i = 0;
	int firstNumber = 1;
	int secondNumber = 1;
	int result = 0;
	for (i = 2; i < number; i++)
	{
		result = firstNumber + secondNumber;
		secondNumber = firstNumber;
		firstNumber = result;	
	}
	return result;
}
