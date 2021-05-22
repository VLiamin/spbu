package ru.liamin.vladimir.Helpers;

import Jama.Matrix;

public class MatrixUtil {


    /**
     * A method that concatenates matrices A and B.
     */
    public static Matrix uniteMatrices(Matrix matrix, Matrix rightPart)
    {
        Matrix copyMatrix = new Matrix(matrix.getRowDimension(), matrix.getColumnDimension() + 1);
        for (int i = 0; i < matrix.getRowDimension(); i++) {
            for (int j = 0; j < matrix.getColumnDimension(); j++) {
                double value = matrix.get(i, j);
                copyMatrix.set(i, j, value);
            }
        }

        for (int i = 0; i < matrix.getRowDimension(); i++) {
            double elem = rightPart.get(0, i);
            copyMatrix.set(i, matrix.getColumnDimension(), elem);
        }

        return copyMatrix;
    }

}