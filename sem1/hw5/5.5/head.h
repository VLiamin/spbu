#pragma once

struct StackElement {
    char value;
    StackElement *next;
};

struct Stack {
    StackElement *head;
};

Stack *createStack();

void add(char x, Stack *&element);

char pop(Stack *stack);

bool isNotEmpty(Stack *stack);

bool isPlusOrMinus(Stack *stack);

void deleteStack(Stack *stack);


