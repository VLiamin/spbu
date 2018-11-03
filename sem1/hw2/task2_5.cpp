#include <stdio.h>
#include <stdlib.h>

const int lengthArray = 1000;

int enter(int *a);

void swap(int *array, int a, int b);

void compare(int numeric, int *a, int length);

void createFoundation(int numeric, int *a);

main()
{
	int i = 0;
	int array[lengthArray];
	int number = enter(array);
	
	createFoundation(number, array);
	
	if (number % 2 == 0)
		i = number - 2;
	else 
		i = number - 3;
	
	while (i > 0)
	{
	   compare(i, array, number);
	   i = i - 2; 	
	}
	
	int change = number;	
	
	while (change - 1 > 0)
	{
		swap(array, 0, change - 1);
		change--;
		for (i = 0; i < change - 1; i++)
		{
			compare(2 * i + 2, array, change - 1);
		}
	}
   
   printf("\n");
   printf("result: ");
   for (i = 0; i < number; i++)
   printf(" %d", array[i]);	
   return 0;
}
 
 void swap(int *array, int a, int b)
{
    int t = array[a];
    array[a] = array[b];
    array[b] = t;	
}

 void compare(int numeric, int *a, int length)
{
	    if (numeric <= length)
	    {
    		if (a[numeric] > a[numeric - 1])
    		{
    			if (a[numeric] > a[int((numeric - 1) / 2)])
    			{
    				swap(a, numeric, int((numeric - 1) / 2));
        		}
			}  
			else
			{
			if (a[numeric - 1] > a[int((numeric - 1) / 2)])
    			{
    				swap(a, numeric - 1, int((numeric - 1) / 2));
        		} 
            }
	   }
	   else 
	   {
	   		if (numeric - 1 <= length)
	   		{
	   			if (a[numeric - 1] > a[int((numeric - 1) / 2)])
    			{
    				swap(a, numeric - 1, int((numeric - 1) / 2));
        		} 	
			}
	   }
}

int enter(int *a)
{
	int date = 0;
	printf("number = ");
	scanf("%d", &date);
	int k = 0;
	
	printf("first array: ");
	for (k = 0; k < date; k++)
	{
		a[k] = rand() % 20;
		printf(" %d", a[k]);
	}
	return date;
}

void createFoundation(int numeric, int *a)
{
	if (numeric % 2 == 0)
	{
    	if (a[numeric - 1] > a[int((numeric - 1) / 2)])
    	{
    		swap(a, numeric - 1, int((numeric - 1) / 2));
		}
	}
	else
	{
		compare(numeric - 1, a, numeric);
	}
}
