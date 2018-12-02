#include <stdio.h>
#include "head.h"

using namespace std;

int main(int argc, char *argv[])
{
    double number = 0.0;
    printf("Your number: ");
	scanf("%lf", &number);
    printExponential(number);
    return 0;
}
