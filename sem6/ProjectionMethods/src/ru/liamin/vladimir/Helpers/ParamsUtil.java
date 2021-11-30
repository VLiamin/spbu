package ru.liamin.vladimir.Helpers;

import java.util.List;

/** The class that contains the constants used in the task */
public class ParamsUtil {

    public static final double alpha1 = 0d;
    public static final double alpha2 = -1d;
    public static final double beta1 = 1d;
    public static final double beta2 = 1d;


    public static double getCoordinationSystemValue(double x, int i, List<Double> jacobiPolynoms) {
        if (i == 0) {
            return 1;
        }

        if (i == 1) {
            return x;
        }

        int n = i - 2;
        return (1 - x * x) * jacobiPolynoms.get(n);
    }


    public static double getCoordinateFuncDerivative(double x, int i, List<Double> jacobiPolynoms) {
        if (i == 0) {
            return 0.0;
        }

        if (i == 1) {
            return 1.0;
        }

        int n = i - 2;
        double polynomNval = jacobiPolynoms.get(n);

        if (i == 2) {
            return -2 * x * polynomNval;
        }

        double k = 1d;
        double polynomN_1val = ((n + 2 * k + 1) / 2) * jacobiPolynoms.get(n - 1);
        return (1 - x * x) * polynomN_1val - 2 * x * polynomNval;
    }


    public static double getCoordinateFuncSndDerivative(
            double x, int i, List<Double> fstPolynomDerivatives) {
        if (i == 0) {
            return 0.0;
        }

        if (i == 1) {
            return 0.0;
        }

        double k = 1;
        int n = i - 2;
        double polynomNval = ((n + 2 * k + 1) / 2) * fstPolynomDerivatives.get(n);

        if (i == 2) {
            return 2 * polynomNval;
        }

        double polynomN_1val = ((n + 2 * k + 1) / 2) * fstPolynomDerivatives.get(n - 1);
        return (1 - x * x) * polynomN_1val - 2 * polynomNval;
    }
}
