package practice;

import java.util.Arrays;

public class MatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowZero = new int[m];
        int[] columnZero = new int[n];
        Arrays.fill(rowZero, 0);
        Arrays.fill(columnZero,0);
        int columnFirst = 0;
        int i = 0,j = 0;
        while(i<m){
            while(j<n){
                if(matrix[i][j] == 0){
                    if(i == 0 && j == 0){
                        columnFirst = 1;
                    }else{
                        columnZero[j] = 1;
                    }
                    rowZero[i] = 1;
                }
                j++;
            }
            i++;
        }
        i = 0;
        while(i < m){
            if(rowZero[i] == 1){
                Arrays.fill(matrix[i], 0);
            }
            i++;
        }
        i = 1;
        while(i < n){
            if(columnZero[i] == 1){
                int r = 0;
                while(r < m){
                    matrix[r][i] = 0;
                    r++;
                }
            }
            i++;
        }
        //fill first column
        if(columnFirst == 1){
            int r = 0;
            while(r < m){
                matrix[r][0] = 0;
                r++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,1}, {1,0,1}, {1,1,1}};
        MatrixZero mz = new MatrixZero();
        mz.setZeroes(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
