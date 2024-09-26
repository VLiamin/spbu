package ru.liamin.vladimir;

public class Counter {

    private double firstBoarder;
    private double secondBoarder;

    public Counter(double firstBoarder, double secondBoarder) {
        this.firstBoarder = firstBoarder;
        this.secondBoarder = secondBoarder;
    }

    public double[] countRectangle(int intervals, double j) {
        double[] numbers = new double[intervals];
        double h = (secondBoarder - firstBoarder) / intervals;
        for (int i = 0; i < intervals; i++) {
            numbers[i] = h * countFunction(firstBoarder + h * i, firstBoarder + h * j);
        }
        return numbers;
    }

    public double[] countTrapezium(int intervals, double j) {

        double[] numbers = new double[intervals];
        double step = Math.abs(secondBoarder + firstBoarder) / (intervals - 1);
        for (int i = 0; i < intervals; i++) {
            if (i != 0 && i != intervals - 1)
                numbers[i] = (countFunction(firstBoarder + i * step, j * step))  * step;
            else
                numbers[i] = countFunction(firstBoarder + i * step, j * step) * step / 2;
        }
        return numbers;
    }

    private double countFunction (double x, double s) {
        return  1 / (3 + x * s);
    }

    public double[] countGauss(double[][] A, double[] b, int border) {
        double[] x = new double[border];
        for (int i = 0; i < border; i++) {
            for (int j = i + 1; j < border; j++) {
                if (Math.abs(A[i][0]) < Math.abs(A[j][0])) {
                    for (int l = 0; l < border; l++) {
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

        for (int k = 0; k < border; k++) {
            double tmp = A[k][k];
            for (int j = k; j < border; j++) {
                A[k][j] /= tmp;
            }
            b[k] /= tmp;

            for (int i = k + 1; i < border; i++) {
                tmp = A[i][k];
                for (int j = k; j < border; j++) {
                    A[i][j] = A[i][j] - A[k][j] * tmp;
                }
                b[i] = b[i] - b[k] * tmp;
            }
        }

        for (int i = border - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < border; j++) {
                sum += x[j] * A[i][j];
            }
            x[i] = b[i] - sum;
        }

        return x;
    }


}
