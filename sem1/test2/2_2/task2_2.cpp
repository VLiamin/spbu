#include <stdio.h>
const int stringLength = 100;
const int lengthData = 12;

bool check(char *string, int &year, int &month, int &day);

void copy(char *string, char *max);

void denote(char *string);

main(int argc, char *argv[])
{
	char string[stringLength];
	int number = 0;
	char min[lengthData];
	int i = 0;
	min[0] = 'b';
	int day = 0;
	int month = 0;
	int year = 0;
	int day2 = 0;
	int month2 = 0;
	int year2 = 0;
	char data[lengthData];
	denote(data);
	denote(min);
	bool write = false;
	FILE *f = fopen("2_2.txt", "r");
	if (f == nullptr)
		return 0; 
	while (fgets(string, stringLength, f))
	{
		i = 0;
		while (string[i] != '\0')
		{
			while (((string[i] > '9') || (string[i] < '0')) && (string[i] != '\n'));
			{
				i++;
			}
			printf("%s", string);
			while (((string[i] <= '9') && (string[i] >= '0') && (string[i] != '\0')) || (string[i] || '.'))
			{
				int l = 0;
				data[l] = string[i];
				i++;
				l++;
			}
			printf("sjj");
			if (min[0] == 'b')
			{
				write = check(data, year2, month2, day2);
					
				copy(data, min);
			}
			else
			{
				day = (min[0] - '0') * 10 + min[1] - '0';
				month = (min[3] - '0') * 10 + min[4] - '0';
				year = (min[6] - '0') * 1000 + (min[7] - '0') * 100 + (min[8] - '0') * 10 + (min[9] - '0'); 
					
				write = check(data, year2, month2, day2);
				if ((write) && (year < year2))
					copy(data, min);
				else if ((write) && (year == year2) && (month < month2))
					copy(data, min);
				else if ((write) && (year == year2) && (month == month2) && (day < day2))
					copy(data, min);
			}
			denote(data);
		}	
	}
	fclose(f);
	i = 0;
	while (min[i] != 'b')
	{
		printf("%c", min[i]);
	}
}

bool check(char *string, int &year, int &month, int &day)
{
	int j = 0;
	day = 0;
	month = 0;
	year = 0;
	while (string[j] != 'b')
	{
		day = (string[0] - '0') * 10 + string[1] - '0';
		if ((string[2] != '.') || (string[5] != '.') || (string[10] != '.'))
		{
			return false;
		}
		month = (string[3] - '0') * 10 + string[4] - '0';
		year = (string[6] - '0') * 1000 + (string[7] - '0') * 100 + (string[8] - '0') * 10 + (string[9] - '0'); 
		if (day > 31)
		{
			return false;

		}
		if (month > 12)
		{
			return false;

		}
		if ((month % 2 == 0) && (day > 30))
			{
				return false;
			}
		if ((month == 2) && (day > 29))
		{
			return false;

		}
	}
	return true;
}

void copy(char *string, char *max)
{
	int j = 0;
	while (string[j] != 'b')
	{
		max[j] = string[j];
		j++;
	}
}
void denote(char *string)
{
	int j = 0;
	while (j < 12)
	{
		string[j] = 'b';
		j++;
	}
}
