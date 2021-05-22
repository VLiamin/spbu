package ru.liamin.vladimir;

import Jama.Matrix;
import ru.liamin.vladimir.Helpers.JacobyPolynom;
import ru.liamin.vladimir.Helpers.MatrixUtil;
import ru.liamin.vladimir.Helpers.ParamsUtil;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

/**
 * A class that implements the Collocation method
 */
public class CollocationSolver {
    private double X;
    private int N;

    private GaussSolver gaussSolver;
    private JacobyPolynom jacobyPolynom;

    private List<Double> listT;
    private List<Double> listC;
    private List<Double> jacobiPolynoms;
    private Matrix matrixA;
    private Matrix rightPart;

    private CountFunction countFunction;

    public CollocationSolver() {
        jacobyPolynom = new JacobyPolynom();
        gaussSolver = new GaussSolver();
        listT = new ArrayList<>();
        countFunction = new CountFunction();
    }

    /** Method that implements the collocation method */
    public double getValue(double x, int n) {
        this.X = x;
        this.N = n;
        this.listT = getListT(n);
        this.matrixA = getMatrixA();
        this.rightPart = getRightPart();
        this.listC = getListC();

        return getSolution();
    }

    /** Method that calculates the solution */
    private double getSolution() {
        double sum = 0d;
        jacobiPolynoms = jacobyPolynom.initPolynoms(N, 1, X);
        for (int i = 0; i < N; i++) {
            double cI = listC.get(i);
            double wI = ParamsUtil.getCoordinationSystemValue(X, i, jacobiPolynoms);
            sum += cI * wI;
        }

        return sum;
    }

    /** Method that calculates the coefficients cJ */
    private List<Double> getListC() {
        Matrix augmentedMatrix = MatrixUtil.uniteMatrices(matrixA, rightPart);
        return gaussSolver.findSolution(augmentedMatrix);
    }

    /** Method that computes the nodes of the Chebyshev polynomial of the first kind tK */
    private List<Double> getListT(int n) {
        List<Double> list = new ArrayList<>();

        for (int k = 1; k <= n; k++) {
            double tK = cos((2 * k - 1) * PI / (2 * n));
            list.add(tK);
        }

        return list;
    }

    /** A method that calculates the coefficients on the left side of an equation */
    private Matrix getMatrixA() {
        Matrix matrix = new Matrix(N, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double tI = listT.get(i);
                double value = getLuValue(j, tI);
                matrix.set(i, j, value);
            }
        }

        return matrix;
    }

    /** Method that calculates the right side of an equation */
    private Matrix getRightPart() {
        Matrix matrix = new Matrix(1, N);

        for (int i = 0; i < N; i++) {
            double tI = listT.get(i);
            double value = countFunction.getValueF(tI);
            matrix.set(0, i, value);
        }

        return matrix;
    }

    /** A method that calculates the left side of an equation */
    private double getLuValue(int j, double tI) {
        jacobiPolynoms = jacobyPolynom.initPolynoms(N, 1, tI);

        double pValue = countFunction.getValueP(tI);
        double pFstDer = countFunction.getFstDerP(tI);

        double wIValue = ParamsUtil.getCoordinationSystemValue(tI, j, jacobiPolynoms);
        double wIfstDer = ParamsUtil.getCoordinateFuncDerivative(tI, j, jacobiPolynoms);
        double wISndDer = ParamsUtil.getCoordinateFuncSndDerivative(tI, j, jacobiPolynoms);

        double rValue = countFunction.getValueR(tI);
        double rFstDer = countFunction.getFstDerR(tI);

        return -(pFstDer * wIfstDer + pValue * wISndDer) + rFstDer * wIValue + rValue * wIfstDer;
    }

    public double countCond(double x) {
        return x * 2;
    }
}
