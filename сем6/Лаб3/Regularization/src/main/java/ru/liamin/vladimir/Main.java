package ru.liamin.vladimir;

public class Main {

    static double a = 0.001;

    public static void main(String[] args) {
        Counter counter = new Counter(0, 1);
        System.out.println("a =     " + 0.001  + "        |       " + 0.0001 + "         |       " + 0.00001 +
                        "         |       " + 0.000001);
        for (int points = 10; points < 100; points = points + 10) {
            while (a > 0.000001) {
                double[][] C = new double[points][points];
                double[] U = new double[points];
                for (int j = 0; j < points; j++) {
                    double[] array = counter.countRectangle(points, j);
                    double sum = 0;
                    for (int i = 0; i < points; i++) {
                        C[i][j] = array[i];
                        sum += array[i];
                    }
                    U[j] = sum;
                }

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
              //          System.out.print(C[i][j] + " ");
                    }
                //    System.out.println();
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

            a = 0.001;
            System.out.println();
            System.out.print("Result(n = " + (points + 10) +  "): " );
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
