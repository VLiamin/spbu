package ru.liamin.vladimir;

import Jama.Matrix;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.TrapezoidIntegrator;
import ru.liamin.vladimir.Helpers.JacobyPolynom;
import ru.liamin.vladimir.Helpers.MatrixUtil;
import ru.liamin.vladimir.Helpers.ParamsUtil;

import java.util.List;

public class RitzSolver {
    private Matrix aIJ;
    private Matrix fI;
    private List<Double> cJ;

    private double X;
    private int N;

    private TrapezoidIntegrator trapezoid;

    private List<Double> jacobiPolynoms;
    private CountFunction countFunction;


    /** Method that implements the Ritz method */
    public double getValue(double x, int n) {
        initFunctions();
        this.X = x;
        this.N = n;

        JacobyPolynom jacobyPolynom = new JacobyPolynom();
        jacobiPolynoms = jacobyPolynom.initPolynoms(N, 1, X);

        trapezoid = new TrapezoidIntegrator();
        aIJ = countAij();
        fI = countFi();
        cJ = countCj();

        return countSolution();
    }

    public double getCondA() {
        double normA = aIJ.normInf();
        Matrix aInversed = aIJ.inverse();
        double normAInversed = aInversed.normInf();
        return normAInversed * normA;
    }

    public Matrix getMatrix() {
        return aIJ;
    }

    /** Method that initializes functions */
    private void initFunctions() {
        countFunction = new CountFunction();
    }

    /** Method that calculates the coefficients of the matrix A */
    private Matrix countAij() {
        Matrix matrix = new Matrix(N, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                final int iConst = i;
                final int jConst = j;

                UnivariateFunction function =
                        v -> {
                            double y = ParamsUtil.getCoordinationSystemValue(v, jConst, jacobiPolynoms);
                            double z = ParamsUtil.getCoordinationSystemValue(v, iConst, jacobiPolynoms);
                            double yDif = ParamsUtil.getCoordinateFuncDerivative(v, jConst, jacobiPolynoms);
                            double zDif = ParamsUtil.getCoordinateFuncDerivative(v, iConst, jacobiPolynoms);
                            return countFunction.getValueP(y) * yDif * zDif + countFunction.getValueR(v) * y * z;
                        };

                double integralValue = trapezoid.integrate(500000, function, -1, 1);

                double y1 = ParamsUtil.getCoordinationSystemValue(1, jConst, jacobiPolynoms);
                double z1 = ParamsUtil.getCoordinationSystemValue(1, iConst, jacobiPolynoms);
                double qL = countFunction.getValueQl(X);
                double qR = countFunction.getValueQr(y1, z1);
                matrix.set(i, j, integralValue + qL + qR);
            }
        }

        return matrix;
    }

    /**  Method that calculates the coefficients fI */
    private Matrix countFi() {
        Matrix fIList = new Matrix(1, N);

        for (int i = 0; i < N; i++) {
            final int iConst = i;
            UnivariateFunction function =
                    v -> {
                        double wI = ParamsUtil.getCoordinationSystemValue(v, iConst, jacobiPolynoms);
                        double fValue = countFunction.getValueF(v);
                        return fValue * wI;
                    };

            double integralValue = trapezoid.integrate(500000, function, -1, 1);
            fIList.set(0, i, integralValue);
        }

        return fIList;
    }

    /** Method that calculates the coefficients cJ */
    private List<Double> countCj() {
        GaussSolver solver = new GaussSolver();
        Matrix augmentedMatrix = MatrixUtil.uniteMatrices(aIJ, fI);
        return solver.findSolution(augmentedMatrix);
    }

    /** Method that calculates the solution */
    private double countSolution() {
        double sum = 0d;
        for (int i = 0; i < N; i++) {
            double cI = cJ.get(i);
            double wI = ParamsUtil.getCoordinationSystemValue(X, i, jacobiPolynoms);
            sum += cI * wI;
        }

        return sum;
    }
}