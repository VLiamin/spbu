package ru.liamin.vladimir;

/** Considers expression */
public class Calculate {

    /**
     * Considers the meaning of the expression
     * @param list list of items stored
     * @return result of the calculation of expression
     */
    public double countExpression(List list) {

        double meaning = 0;
        double variable1 = 0;
        double variable2 = 0;
        Stack stack = new Stack();

        while (list.count() > 0) {

            while (list.removeSign() == 'b') {
                stack.push(list.pop());
            }
            while ((0 < list.count()) && (list.removeSign() != 'b')) {
                variable1 = stack.pop();
                variable2 = stack.pop();
                if (list.removeSign() == '-')
                    meaning = variable2 - variable1;
                else if (list.removeSign() == '+')
                    meaning = variable2 + variable1;
                else if (list.removeSign() == '*')
                    meaning = variable2 * variable1;
                else {
                    if (variable1 == 0)
                        throw new ArithmeticException("Division by zero");
                    meaning = variable2 / variable1;
                }

                stack.push(meaning);
                list.pop();
            }
        }

        stack.clear();
        list.push(meaning, 'b', 1);
        return meaning;
    }
}