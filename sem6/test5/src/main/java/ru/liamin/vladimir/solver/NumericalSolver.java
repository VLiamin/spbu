package ru.liamin.vladimir.solver;

import static java.lang.Math.sqrt;

import org.apache.commons.math3.complex.Complex;
import ru.liamin.vladimir.util.Function;
import ru.liamin.vladimir.util.FunctionG;


public class NumericalSolver {


  public double getValue(double t, int n, int m, double r) {
    Complex result = Complex.valueOf(0d, 0d);

    for (int j = 1; j <= m; j++) {
      Complex expValue = FunctionG.getExpValue(j, m);
      Complex rExpValue = expValue.multiply(r);
      Complex fstFactor = rExpValue.pow(-n); // pow(r * expValue, -n);
      // 1 / (1 - r * exp)
      Complex idComplex = Complex.valueOf(1d);
      Complex sndFactor = idComplex.divide(idComplex.subtract(rExpValue));

      Complex p = (idComplex.subtract(rExpValue)).divide(t).multiply(n);
      Complex fiValue = Function.getValue(p).multiply(p);

      Complex fstSndFactor = fstFactor.multiply(sndFactor);
      Complex fstSndFiFactor = fstSndFactor.multiply(fiValue);
      result = result.add(fstSndFiFactor);
    }

    double resultReal =  result.getReal();
    double resultImag =  result.getImaginary();
    return sqrt(resultReal * resultReal + resultImag * resultImag);
  }
}
