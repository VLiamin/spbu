package ru.liamin.vladimir;


public class Eigenvalues {

    private double[][] y;
    private double[] p;

    public double[] findEigenvalues (double[][] A) {
        double[] numbers = new double[A.length];
        double[][] y = new double[A.length][A.length + 1];
        y[0][0] = 1;
        for (int i = 1; i < y.length; i++) {
            y[i][0] = 0;
        }

        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 0; j < A.length; j++) {
                double sum = 0;
                for (int k = 0; k < A.length; k++) {
                    sum += A[j][k] * y[k][i - 1];
                }
                y[j][i] = sum;
            }
        }


        double[] b = new double[A.length];
        double[][] newY = new double[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            b[i] = y[i][A.length];
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                newY[i][j] = y[i][A.length - 1 - j];
            }
        }

        double[] p = countGauss(newY, b);

        this.p = p;
        this.y = y;

        return findRoutes(p);
    }

    public double[][] findOwnVectors (double[] numbers) {
        double[][] vectors = new double[numbers.length][numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            double[] q = new double[numbers.length];
            q[0] = 1;
            for (int j = 1; j < q.length; j++) {
                q[j] = numbers[i] * q[j - 1] - p[j - 1];
            }

            for (int j = 0; j < vectors.length; j++) {
                double sum = 0;
                for (int k = 0; k < q.length; k++) {
                    sum += y[j][k] * q[q.length - k - 1];
                }
                vectors[j][i] = sum;
            }
    }
        return vectors;
    }

    private double[] countGauss(double[][] A, double[] b) {
        double[] x = new double[b.length];
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if (Math.abs(A[i][0]) < Math.abs(A[j][0])) {
                    for (int l = 0; l < b.length; l++) {
                        double temp = A[i][l];
                        A[i][l] = A[j][l];
                        A[j][l] = temp;
                    }
                    double temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }

        for (int k = 0; k < b.length; k++) {
            double tmp = A[k][k];
            for (int j = k; j < b.length; j++) {
                A[k][j] /= tmp;
            }
            b[k] /= tmp;

            for (int i = k + 1; i < b.length; i++) {
                tmp = A[i][k];
                for (int j = k; j < b.length; j++) {
                    A[i][j] = A[i][j] - A[k][j] * tmp;
                }
                b[i] = b[i] - b[k] * tmp;
            }
        }

        for (int i = b.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < b.length; j++) {
                sum += x[j] * A[i][j];
            }
            x[i] = b[i] - sum;
        }

        return x;
    }

    private double[] findRoutes(double[] p) {
        double[] routes = new double[p.length];

        double h = -100;
        int number = 0;

        while (h < 1000) {

            h += 0.0001;
            if (isSignChange(p, h)) {
                double temp = h - 0.0001;
                while (temp < h) {
                    temp += 0.000000001;
                    if (Math.abs(functionValue(p, temp)) < 0.0000001) {
                        routes[number] = temp;
                        number++;
                        break;
                    }
                }
            }
        }
        return routes;
    }

    private boolean isSignChange(double[] p, double x) {

            double value = 0;

            for (int i = 0; i < p.length; i++) {
                double mul = 1;
                for (int j = 0; j < p.length - i; j++) {
                    mul *= x;
                }
                if (i == 0) {
                    value += mul;
                } else {
                    value -= p[i - 1] * mul;
                }
            }
            value -= p[p.length - 1];

            double value2 = 0;

            for (int i = 0; i < p.length; i++) {
                double mul = 1;
                for (int j = 0; j < p.length - i; j++) {
                    mul *= (x - 0.0001);
                }
                if (i == 0) {
                    value2 += mul;
                } else {
                    value2 -= p[i - 1] * mul;
                }
            }
            value2 -= p[p.length - 1];

            return value * value2 < 0;


    }

    private double functionValue(double[] p, double x) {
        double value = 0;

        for (int i = 0; i < p.length; i++) {
            double mul = 1;
            for (int j = 0; j < p.length - i; j++) {
                mul *= x;
            }
            if (i == 0) {
                value += mul;
            } else {
                value -= p[i - 1] * mul;
            }
        }
        value -= p[p.length - 1];
        return value;
    }
}
