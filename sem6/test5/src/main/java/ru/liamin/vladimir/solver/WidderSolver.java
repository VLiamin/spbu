package ru.liamin.vladimir.solver;

import static java.lang.Math.pow;

import ru.liamin.vladimir.util.Factorial;
import ru.liamin.vladimir.util.Function;

public class WidderSolver {


  public double getValue(double t, int n) {
    double p = n / t;
    double derivativeF = Function.getDerivative(p, n);
    double sign = n % 2 == 0 ? 1d : -1d;
    double factorial = Factorial.getValue(n);
    double pN = pow(p, n + 1);
    return sign * pN * derivativeF / factorial;
  }
}
