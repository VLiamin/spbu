package ru.liamin.vladimir;

/** To calculate the expression class */
public class Calculate {
    private double result;

    /**
     * o calculate the expression method
     * @param value1 first number
     * @param value2 second number
     * @param sign arithmetic sign of the operation
     * @return result of the calculation of expression
     */
    public String count(int value1, int value2, String sign){

        if (sign.equals("-"))
            result = value1 - value2;
        if (sign.equals("+"))
            result = value1 + value2;
        if (sign.equals("*"))
            result = value1 * value2;
        if (sign.equals("/")){
            if (value2 == 0)
                throw new ArithmeticException("Division by zero");
            result = (double) value1 / value2;}
        return Double.toString(result);
    }
}
