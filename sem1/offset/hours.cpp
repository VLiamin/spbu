#include <stdio.h>
const int length = 24;
int main()
{
	int minute = 0;
	int hourStart = 0;
	int hourFinish = 0;
	int hours[length];
	int i = 0;
	for (i = 0; i < length; i++)
	{
		hours[i] = 0;
	}
	FILE *f = fopen("text.txt", "r");
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
	int max = -1;
	int maxHour = -1;
	for (int i = 0; i < length; i++)
	{
		if (hours[i] > max)
		{
			max = hours[i];
		}
	}
	for (int i = 0; i < length; i++)
	{
		if (hours[i] == max)
		{
			printf("maxHour: %d\n", i);
		}
	}
	fclose(f);
	return 0;
}
