package ru.liamin.vladimir;

import Jama.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GaussSolver {

    private Integer MATRIX_SIZE;

    /**
     * A method that finds a solution to a system using the Gaussian algorithm
     *
     * @param matrix -- matrix А, defined in the array of Double
     * @return -- system solution
     */
    public List<Double> findSolution(Matrix matrix) {
        this.MATRIX_SIZE = matrix.getRowDimension();
        Matrix triangleSystem = performRightProgress(matrix);
        return performReverseProgress(triangleSystem);
    }

    /**
     * A method that implements the forward run of the Gaussian algorithm
     *
     * @param matrix -- matrix А, defined in the array of Double
     * @return -- upper triangular matrix
     */
    public Matrix performRightProgress(Matrix matrix) {
        subtractPrevious(matrix);
        return matrix;
    }

    /**
     * A method that reverses the Gaussian algorithm
     *
     * @param triangleMatrix -- matrix А, defined in the array of Double
     * @return -- system solution
     */
    public List<Double> performReverseProgress(Matrix triangleMatrix) {
        List<Double> solutions = new ArrayList<>();
        Double solution;
        for (int i = MATRIX_SIZE - 1; i >= 0; i--) {
            solution = 0D;
            for (int j = i + 1; j < MATRIX_SIZE; j++) {
                solution -= triangleMatrix.get(i, j) * solutions.get(MATRIX_SIZE - j - 1);
            }

            solution += triangleMatrix.get(i, MATRIX_SIZE);
            solutions.add(solution);
        }

        Collections.reverse(solutions); // меняем местами x1 и x2
        return solutions;
    }

    /**
     * A method in which each element of the matrix above the diagonal is divided by the diagonal element
     * @param matrix -- system matrix
     */
    private void divideByDiagonal(Matrix matrix, int stringNumber) {
        Double tmp = matrix.get(stringNumber, stringNumber);
        for (int i = 0; i < MATRIX_SIZE + 1; i++) {
            Double curElem = matrix.get(stringNumber, i); // a[stringNumber][j]
            curElem = curElem / tmp;
            matrix.set(stringNumber, i, curElem);
        }
    }

    /**
     * A method in which the previous line is subtracted from the current line.
     * @param matrix -- system matrix
     */
    private void subtractPrevious(Matrix matrix) {
        Double tmp = 0D;
        for (int k = 0; k < MATRIX_SIZE; k++) {
            divideByDiagonal(matrix, k);
            for (int i = k + 1; i < MATRIX_SIZE; i++) {
                tmp = matrix.get(i, k); // a[i][k]
                for (int j = k; j < MATRIX_SIZE + 1; j++) {
                    Double curElem = matrix.get(i, j); // a[i][j]
                    Double prevElem = matrix.get(k, j); // a[k][j]
                    curElem = curElem - prevElem * tmp;
                    matrix.set(i, j, curElem);
                }
            }
        }
    }
}
