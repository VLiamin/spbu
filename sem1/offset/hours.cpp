#include <stdio.h>

const int length = 24;

void readFile(FILE *f, int *hours);
int findMax(int *hours);
void printMax(int max, int *hours);

int main()
{
	int hours[length];
	int i = 0;
	for (i = 0; i < length; i++)
	{
		hours[i] = 0;
	}
	
	FILE *f = fopen("text.txt", "r");
	readFile(f, hours);
	
	fclose(f);
	int max = -1;
	int maxHour = -1;
	
	max = findMax(hours);
	
	printMax(max, hours);
	
	return 0;
}

void readFile(FILE *f, int *hours)
{
	int minute = 0;
	int hourStart = 0;
	int hourFinish = 0;
	int i = 0;
	while (!feof(f))
	{
		fscanf(f, "%d", &hourStart);
		fscanf(f, "%d", &minute);
		fscanf(f, "%d", &hourFinish);
		fscanf(f, "%d", &minute);
		for (i = hourStart; i <= hourFinish; i++)
		{
			hours[i]++;
		}
	}
}

int findMax(int *hours)
{
	int max = -1;
	for (int i = 0; i < length; i++)
	{
		if (hours[i] > max)
		{
			max = hours[i];
		}
	}
	return max;
}

void printMax(int max, int *hours)
{
	for (int i = 0; i < length; i++)
	{
		if (hours[i] == max)
		{
			printf("maxHour: %d\n", i);
		}
	}
}
