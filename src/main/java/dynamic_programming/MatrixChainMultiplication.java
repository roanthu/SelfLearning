package dynamic_programming;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixChainMultiplication {

    public static class Matrix{
        public static Random random = new SecureRandom();
        public long[][] matrix;
        public String name = "";
        public Matrix(long[][] matrix, String name){
            this.matrix = matrix;
            this.name = name;
        }

        public Matrix(int m, int n, String name){
            this.name = name;
            matrix = new long[m][n];
            for (int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = random.nextInt(50);
                }
            }
        }


        public int getCol(){
            return matrix[0].length;
        }

        public int getRow(){
            return matrix.length;
        }

        public long value(int i, int j){
            return matrix[i][j];
        }

        public void set(int i, int j, long value){
            matrix[i][j] = value;
        }

        public void print(){
            System.out.printf(toString());
        }

        @Override
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("matrix ").append(name).append("\n");
            for (int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    stringBuilder.append(matrix[i][j]).append(" ");
                }
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }

    }

    public Matrix multiMatrix(Matrix matrixA, Matrix matrixB){
        long[][] array = new long[matrixA.getRow()][matrixB.getCol()];
        Matrix ret = new Matrix(array, "result");
        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixB.getCol(); j++) {
                for (int k = 0; k < matrixB.getRow(); k++)
                    ret.set(i, j, ret.value(i, j) + matrixA.value(i, k) * matrixB.value(k, j));
            }
        }
        return ret;
    }

    public List<Matrix> randomMatrixList(int col, int row, int size){
        List<Matrix> matrixList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Matrix matrix = null;
            if(i%2 == 0){
                matrix = new Matrix(col, row, i+"");
            }else {
                matrix = new Matrix(row, col, i+"");
            }
            matrixList.add(matrix);
        }
        return matrixList;
    }

    public Matrix multiMatrixChain(List<Matrix> chain){
        Matrix ret = chain.get(0);
        for(int i = 1; i < chain.size(); i++){
            ret = multiMatrix(ret, chain.get(i));
        }
        return ret;
    }

    public static void main(String[] args){
        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
        Matrix matrixA = new Matrix(2, 2, "matrixA");
        matrixA.print();

        Matrix matrixB = new Matrix(2, 2, "matrixB");
        matrixB.print();

        Matrix result = matrixChainMultiplication.multiMatrix(matrixA, matrixB);
        result.print();

        List<Matrix> randomList = matrixChainMultiplication.randomMatrixList(4, 6, 5);
        System.out.println(randomList);

        result = matrixChainMultiplication.multiMatrixChain(randomList);
        System.out.println(result);
    }
}
