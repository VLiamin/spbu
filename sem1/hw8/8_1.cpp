#include <stdio.h>

int findOriginal(int *studentWorks, int student);

void getPairs(int *studentWorks, int number);

void print(int *studentWorks, int number);

int main()
{
    int number = 0;
    printf("Number of students: ");
    scanf("%d", &number);

    int *studentWorks = new int[number + 1];
    for (int i = 0; i <= 2; i++) 
    {
        studentWorks[i] = i + 1;
    }
    getPairs(studentWorks, number);

    print(studentWorks, number);
    delete[] studentWorks;
    return 0;
}

int findOriginal(int *studentWorks, int student)
{
    if ((1 <= student) && (student <= 3)) 
    {
        return student;
    }
    else if (studentWorks[student] == -1)
    {
        return -1;
    }
    else
    {
        int option = findOriginal(studentWorks, studentWorks[student]);
        studentWorks[student] = option;
        return option;
    }
}

void getPairs(int *studentWorks, int number)
{
    printf("Dishonest students (not first three)\n");
    for (int i = 0; i <= number - 4; i++) 
    {
        int student = 0;
        printf("Number of student: ");
        scanf("%d", &student);
        int option = 0;
        printf("From whom he wrote off: ");
        scanf("%d", &option);
        studentWorks[student] = option;
    }
}

void print(int *studentWorks, int number)
{
	printf("\n");
	printf("          RESULT\n");
    for (int i = 0; i <= number - 1; i++)
    {
        int option = findOriginal(studentWorks, i + 1);
        if (option == -1)
        {
            printf("Student %d didn't do the task\n", i + 1);
        }
        else
        {
            printf("Student %d do the option %d\n", i + 1, option);
        }
    }
}

