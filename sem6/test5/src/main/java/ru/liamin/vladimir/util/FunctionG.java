package ru.liamin.vladimir.util;

import static java.lang.Math.PI;
import static org.apache.commons.math3.complex.Complex.I;

import org.apache.commons.math3.complex.Complex;


public class FunctionG {


  public static double getValue(double z, double t) {
    return 1 / t * Function.getValue((1 - z) / t);
  }


  public static Complex getExpValue(double x, int m) {
    return I.multiply(2 * PI * x / m).exp();
  }
}
