#include <stdio.h>

char* allocateMemory(char *string, int i);
char* filing(FILE *f, char* string);

const int multiplier = 256;
const int modulo = 31;

int main()
{
    FILE *f = fopen("text.txt", "r");
    char *string = new char[20];
    string = filing(f, string);
    char *substring = new char[20];
    substring = filing(f, substring);
    int i = 0;
    int cashSubstring = 0;
    int cashString = 0;
    while (substring[i] != '\n')
    {
        if (string[i] == '\n')
        {
            printf("Substring > String");
            delete [] string;
            delete [] substring;
            return 0;
        }
        cashSubstring = (multiplier * cashSubstring + substring[i]) % modulo;
        cashString = (multiplier * cashString + string[i]) % modulo;
        i++;
    }

    int length = i;
    int power = 1;
    for (int j = 1; j < length; j++)
        power = (power * multiplier) % modulo;
    bool areEqual = true;
    while (string[i] != '\n')
    {
        areEqual = true;
        if (cashSubstring == cashString)
        {
            for (int j = 0; j < length; j++)
            {
                if (substring[j] != string[i - length + j])
                    areEqual = false;
            }
            if (areEqual == true)
                printf("The similarity begins from: %d\n", i - length);
        }
        cashString = (multiplier * (cashString + modulo - (string[i - length] * power) % modulo) + string[i]) % modulo;

        i++;
    }
    if (cashSubstring == cashString)
    {
        for (int j = 0; j < length; j++)
        {
            if (substring[j] != string[i - length + j])
                areEqual = false;
        }
        if (areEqual == true)
            printf("The similarity begins from: %d\n", i - length);
    }

    delete [] string;
    delete [] substring;
    fclose(f);
    return 0;
}

char* allocateMemory(char *string, int i)
{
    char *string2 = new char[i + 20];

    for (int j = 0; j < i; j++)
    {
        string2[j] = string[j];
    }
    delete [] string;
    return string2;
}

char* filing(FILE *f, char* string)
{
    int i = 0;
    char x = 'b';
    fscanf(f, "%c", &x);
    string[i] = x;
    while (string[i] != '\n')
    {
        i++;
        if (i % 20 == 0) {
            string = allocateMemory(string, i);
        }
        fscanf(f, "%c", &x);
        string[i] = x;
        if (feof(f))
            string[i] = '\n';
    }
    return string;
}
