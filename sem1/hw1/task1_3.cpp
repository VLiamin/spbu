#include <stdio.h>
const int con = 1000;
void reverse(int beg, int first_len, int second_len, int *array);
main()
{
	int m = 0;
	int n = 0;
	printf("m = ");
	scanf("%d", &m);
	printf("n = ");
	scanf("%d", &n);
	int a[con];
	for (int i = 0; i < m + n; i++) 
	{
		a[i] = i;
	}
	reverse(0, m, 0, a);
	reverse(m, 2 * m, n, a);
	reverse(0, m, n, a);
	
	for (int i = 0; i < m + n; i++) 
	{
		printf(" %d", a[i]);  
	}
	return 0;
}
void reverse(int beg, int first_len, int second_len, int *array)
{
	int t;
	for (int j = beg; j < int((first_len + second_len) / 2); j++)
	{
		t = array[j];
	   	array[j] = array[first_len + second_len - j -1];
	   	array[first_len + second_len - j - 1] = t;
	}		
} 


