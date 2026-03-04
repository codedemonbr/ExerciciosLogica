package com.codedemonbr;

public class Matrix {
    private static int[][] newMatrix(int[][] matrix, int posX, int posY){
        int rows = matrix.length;
        int newSize = rows - 1;
        int res[][] = new int[newSize][newSize];
        int m = 0;
        int n = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if(i != posX && j != posY){
                    res[m][n] = matrix[i][j];
                    n++;
                    if(n > (newSize - 1)){
                        m++;
                        n = 0;
                    }
                }
            }
        }
        return res;
    }
    public static int determinant(int[][] matrix) {
        // Your code here!
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(matrix != null && rows == columns && rows > 0){
            if(rows == 1){
                return matrix[0][0];
            }
            if(rows == 2){
                return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
            }
            int acc = 0;
            for (int i = 0; i < rows; i++) {
                if(i % 2 == 0){
                    acc = acc + matrix[0][i] * determinant(newMatrix(matrix, 0, i));
                }else{
                    acc = acc - matrix[0][i] * determinant(newMatrix(matrix, 0, i));

                }
            }
            return acc;
        }
        return 0;
    }
}