package ru.liamin.vladimir;

public class SearchB {

    public double[][] findB(double[][] vectors, double[] numbers) {
        double[][] B = new double[numbers.length][numbers.length];
        double[][] reverse = findReverseMatrix(vectors);


        double[][] matricesNumbers = new double[numbers.length][numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    matricesNumbers[i][j] = 0;
                } else {
                    matricesNumbers[i][i] = Math.sqrt(numbers[i]);
                }
            }
        }


        double[][] newNumbers = new double[numbers.length][numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            for (int l = 0; l < newNumbers.length; l++) {
                double sum = 0;
                for (int j = 0; j < newNumbers.length; j++) {
                    sum += vectors[i][j] * matricesNumbers[j][l];
                }
                newNumbers[i][l] = sum;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int l = 0; l < newNumbers.length; l++) {
                double sum = 0;
                for (int j = 0; j < newNumbers.length; j++) {
                    sum += newNumbers[i][j] * reverse[j][l];
                }
                B[i][l] = sum;
            }
        }

        return B;
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
}
