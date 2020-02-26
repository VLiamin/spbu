package ru.liamin.vladimir;

/** Class implements tree */
public class Tree {

    private Node head;

    /**
     * Add elements to a tree
     * @param expression prefix arithmetic expression
     */
    public void push(char[] expression) {
        head = new Node();
        head.buildTree(expression, 0);
    }

    /** Print tree on console */
    public void print() {
        head.print();
    }

    /**
     * Count expression
     * @return expression value
     */
    public int count() {
        return head.count();
    }

    private class Node {
        private int number;
        private Node right;
        private Node left;
        private char symbol;

        private int searchTokenStart(char[] expression, int i) {
            int sum = 0;
            if (expression[i] == '(') {
                sum++;
                i++;
                while (sum != 0) {
                    if (expression[i] == '(')
                        sum++;
                    else if (expression[i] == ')')
                        sum--;
                    i++;
                }
                while (expression[i] == ' ') {
                    i++;
                }
            } else {
                i++;
                while (expression[i] != ' ') {
                    i++;
                }
                while (expression[i] == ' ') {
                    i++;
                }
            }
            return i;
        }

        private void buildTree(char[] expression, int i) {
            if (expression[i] == '(') {
                i++;
                while (expression[i] == ' ') {
                    i++;
                }
                right = null;
                left = null;
                number = 0;
                symbol = expression[i];
                i++;
                while (expression[i] == ' ') {
                    i++;
                }
                int firstTokenStart = i;
                int secondTokenStart = searchTokenStart(expression, firstTokenStart);
                left = new Node();

                left.buildTree(expression, firstTokenStart);
                right = new Node();
                right.buildTree(expression, secondTokenStart);
                return;
            } else {
                int value = 0;
                while ((expression[i] >= '0') && (expression[i] <= '9')) {
                    value = value * 10 + expression[i] - '0';
                    i++;
                }
                right = null;
                left = null;
                number = value;
                symbol = 'b';
                return;
            }
        }

        private void print() {
            if (left != null)
                System.out.print("(");
            if (left != null)
                left.print();

            if (symbol != 'b')
                System.out.print(" " + symbol + " ");
            else
                System.out.print(number);
            if (right != null)
                right.print();
            if (left != null) {
                System.out.print(")");
            }
        }

        private int count() throws ArithmeticException {
            if (left == null) {
                return number;
            }

            switch (symbol) {
                case '+':
                    return left.count() + right.count();
                case '-':
                    return left.count() - right.count();
                case '*':
                    return left.count() * right.count();
                case '/':
                    if (right.count() == 0)
                        throw new ArithmeticException("Division by zero");
                    return left.count() / right.count();
            }
            return number;
        }
    }
}
