package ru.liamin.vladimir;

public class Main {

    public static void main(String[] args) {
        for (int n = 2; n <= 5; n++) {
            double[][] A = findMatrix(n);
            Eigenvalues eigenvalues = new Eigenvalues();


            double[] numbers = eigenvalues.findEigenvalues(A);

        System.out.println("Own numbers (n = " + n + ")");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println();
            double[][] vectors = eigenvalues.findOwnVectors(numbers);

  /*      System.out.println("Vectors");
        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors.length; j++) {
                System.out.print(vectors[i][j] + " | ");
            }
            System.out.println();
        }*/

            SearchB searchB = new SearchB();

            double[][] B = searchB.findB(vectors, numbers);

            Results results = new Results();
          //   System.out.println(String.format("n = %d  | Cond A: %.10f | Cond B: %.10f | B^2 - A: %.10f",
          //          n, results.findCond(A), results.findCond(B), results.subtract(B, A)));

        }

    }

    private static double[][] findMatrix(int n) {
        double[][] matrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double a = 1;
                for (int l = 0; l < 4; l++) {
                    a /= (n - i);
                }
                double b = 1;
                for (int l = 0; l < 4; l++) {
                    b /= (n - j);
                }
                matrix[i][j] = Math.pow(a, b);
            }

        }
        return matrix;
    }
}
