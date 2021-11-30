package ru.liamin.vladimir;


/** Main class */
public class Main {

    private static final double x1 = -0.5;
    private static final double x2 = 0.0;
    private static final double x3 = 0.5;
    private static final int startN = 3;
    private static final int endN = 7;

    private static RitzSolver ritzSolver;
    private static CollocationSolver collocationSolver;

    /** Main method */
    public static void main(String[] args) {
        System.out.println("Задание № 6.");
        System.out.println("Вариант № 1.");
        System.out.println("-( 1 / (2 + x) * u')' + cos(x) * u = 1 + x,");
        System.out.println("u'(-1) = u'(1)+ u(1) = 0");
        System.out.println("Координатная система : 1, x, (1 - x^2) * P(i, 1, 1)(x), i = 0, 1, ...");
        System.out.println();
        double[] condA = new double[5];
        ritzSolver = new RitzSolver();
        collocationSolver = new CollocationSolver();

        System.out.println("Ritz method");
        System.out.println("n  |     cond(A)            |        y^n(-0.5)          |          y^n(0)        |     y^n(-0.5)");
        for (int i = startN; i <= endN; i++) {
            double ritzX1Val = ritzSolver.getValue(x1, i);
            double ritzX2Val = ritzSolver.getValue(x2, i);
            double ritzX3Val = ritzSolver.getValue(x3, i);
            System.out.println(i + "   |  "  + ritzSolver.getCondA() + "    |    "  + ritzX1Val + " | " +
                    ritzX2Val + " | " + ritzX3Val);
            condA[i - 3] = ritzSolver.getCondA();
        }
        System.out.println();
        System.out.println("Ritz method");
        System.out.println("n  |     cond(A)            |        y^n(-0.5)          |          y^n(0)        |     y^n(-0.5)");
        for (int i = startN; i <= endN; i++) {
            double colX1Val = collocationSolver.getValue(x1, i);
            double colX2Val = collocationSolver.getValue(x2, i);
            double colX3Val = collocationSolver.getValue(x3, i);
            System.out.println(i + "   |  "  + collocationSolver.countCond(condA[i - 3]) + "    |    "  + colX1Val + " | " +
                    colX2Val + " | " + colX3Val);
        }

    }

}
