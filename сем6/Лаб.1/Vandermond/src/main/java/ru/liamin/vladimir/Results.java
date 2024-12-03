package ru.liamin.vladimir;

public class Results {

    public double findCond(double[][] A) {
        double[][] reverse = findReverseMatrix(A);
        return countNorm(A) * countNorm(reverse);
    }


    public double[][] findReverseMatrix(double[][] matrix) {

        double[][] A = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                A[i][j] = matrix[i][j];
            }

        }

        double[][] reverseMatrix = new double[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j)
                    reverseMatrix[i][j] = 1;
                else
                    reverseMatrix[i][j] = 0;
            }
        }

        for (int k = 0; k < A.length; k++) {
            double temp = A[k][k];
            for (int i = 0; i < A.length; i++) {
                A[k][i] /= temp;
                reverseMatrix[k][i] /= temp;
            }

            for (int i = 0; i < A.length; i++) {
                if (i == k)
                    continue;
                double temp2 = A[i][k] / A[k][k];
                for (int j = 0; j < A.length; j++) {
                    A[i][j] = A[i][j] - temp2 * A[k][j];
                    reverseMatrix[i][j] = reverseMatrix[i][j] - temp2 * reverseMatrix[k][j];
                }
            }
        }

        return reverseMatrix;
    }

    private double countNorm(double[][] A) {

        double max = 0;
        double temp = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                temp += Math.abs(A[j][i]);
            }
            if (temp > max)
                max = temp;
            temp = 0;
        }
        return max;
    }

    public double subtract(double[][] B, double[][] A) {
        double[][] B2 = new double[B.length][B.length];

        for (int i = 0; i < B.length; i++) {
            for (int l = 0; l < B.length; l++) {
                double sum = 0;
                for (int j = 0; j < B.length; j++) {
                    sum += B[i][j] * B[j][l];
                }
                B2[i][l] = sum;
            }
        }

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                B2[i][j] = B2[i][j] - A[i][j];
            }
        }

        return countNorm(B2);
    }
}
