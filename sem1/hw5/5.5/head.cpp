#include "head.h"

Stack *createStack() {
    return new Stack{nullptr};
}

void add(char x, StackElement *&element) {
    StackElement *temp = new StackElement;
    temp->value = x;
    temp->next = element;
    element = temp;

}

void add(char x, Stack *&stack) {
    add(x, stack->head);
}

char pop(StackElement *&element) {
    if (element != nullptr) {
        char value = element->value;
        StackElement *temp = element->next;
        delete element;
        element = temp;
        return value;
    }
    return 'b';
}

char pop(Stack *element) {
    return pop(element->head);
}

bool isNotEmpty(StackElement *element) {
    if (element != nullptr) return true;

    return false;
}

bool isNotEmpty(Stack *stack) {
    return isNotEmpty(stack->head);
}

bool isPlusOrMinus(StackElement *element) {
    if (element == nullptr) return false;
    if ((element->value == '-') || (element->value == '+')) return true;
    return false;
}

bool isPlusOrMinus(Stack *stack) {
    return isPlusOrMinus(stack->head);
}

void deleteStack(StackElement *element) {
    StackElement *tmp = element;
    while (element) {
        element = element->next;
        delete tmp;
        tmp = element;
    }
}

void deleteStack(Stack *stack) {
    deleteStack(stack->head);
    delete stack;
}

