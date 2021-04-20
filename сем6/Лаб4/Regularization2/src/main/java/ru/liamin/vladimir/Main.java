package ru.liamin.vladimir;

import java.util.List;

public class Main {
    static double a = 0.00001;
    private  static double X = 0.5;
    private  static double H = 0.5;

    public static void main(String[] args) {
        Counter counter = new Counter(0, 1);
        System.out.println("a =     " + 0.00001  + "        |       " + 0.000001 + "         |       " + 0.0000001 +
                "         |       " + 0.00000001);
        System.out.print("Result(n = " + (2) +  "): " );

        for (int points = 2; points < 10; points++) {
            while (a > 0.00000001) {
                double[][] C = new double[points][points];
                double[] U = new double[points];

                for (int j = 0; j < points; j++) {
                    double xJ = X + j * H;
                    List<Double> coefs = counter.getIntegralInMomentCoefs(j, H, points);
                    double sum = 0d;
                    for (int k = 0; k < points; k++) {
                        double dJK = j == k ? 1 : 0;
                        double aK = coefs.get(k);
                        double xK = X + k * H;
                        double hJK = counter.countFunctionA(xK);
                        dJK -= aK * hJK;
                        C[j][k] = dJK;
                        sum += dJK;
                    }

                    U[j] = sum;
                }

                double[][] conjugateMatrix = new double[points][points];

                for (int i = 0; i < points; i++) {
                    for (int j = 0; j < points; j++) {
                        conjugateMatrix[i][j] = C[j][i];
                    }
                }

                double[][] C1C2 = multiplyMatrix(C, conjugateMatrix);

                for (int i = 0; i < points; i++) {
                    for (int j = 0; j < points; j++) {
                        if (i != j)
                            C1C2[i][j] = C1C2[j][i];
                        else
                            C1C2[i][j] = C1C2[j][i] - a;
                    }
                }

                double[] values = counter.countGauss(C1C2, U, points);

                double sum = 0;
                for (int i = 0; i < points; i++) {
                    sum += values[i] * values[i];
                }

                System.out.print(Math.sqrt(sum) / 1000 + "  | " );
                a = a * 0.1;
            }

            a = 0.00001;
            System.out.println();
            System.out.print("Result(n = " + (points + 1) +  "): " );
        }
    }

    private static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                double sum = 0;
                for (int l = 0; l < matrix1.length; l++) {
                    sum += matrix1[i][l] * matrix2[l][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
