#ifndef head_H
#define head_H
struct node
{
    int value;                          
    node *left;
	node *right;  
	node *tree;                      
};

void push(int number, node **tree);   
void printIn(node *tree);
node* add(int number, node *tree);
void printDe(node *tree);
bool found(int number, node *tree);
void printABC(node *tree);
#endif
