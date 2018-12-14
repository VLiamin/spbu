#include <stdio.h>

int main(int argc, char *argv[])
{
	int i = 0;
	int j = 0;
	int column = 0;
	int string = 0;
	printf("number of columns: ");
	scanf("%d", &column);
	printf("number of strings: ");
	scanf("%d", &string);
	int **array = new int* [string];
	int *min = new int[string];
	for (int count = 0; count < string; count++)
	{
		array[count] = new int [column];
	}
        
        
	printf("numbers:\n");
	for (i = 0; i < string; i++)
	{
		for (j = 0; j < column; j++)
		{
			scanf("%d", &array[j][i]);
			if (j == 0)
				min[i] = array[j][i];
			else if (min[i] > array[j][i])
			{
				min[i] = array[j][i];
			}
		}
	}
	
	for (i = 0; i < string; i++)
	{
		for (j = 0; j < column; j++)
		{
			
		    printf(" %d", array[j][i]);
		}
		printf("\n");
	}
	for (i = 0; i < string; i++)
	{
		for (j = 0; j < column; j++)
		{
			if (array[j][i] == min[i])
			{
				for (int l = 0; l < string; l++)
				{
					if (min[i] < array[j][l])
						break;
					if (l == string - 1)
						printf("coordinates: %d, %d\n", i, j);
				}
			}
		}
	}
	delete [] min;
	for (int count = 0; count < string; count++)
		delete [] array[count]; 
	return 0;
}
