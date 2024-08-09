package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] row1 = new int[n+1];
        int[] row2 = new int[n+1];
        Set<Integer> s = new HashSet<>();
        Arrays.fill(row1, 1);
        int i ;
        int j = m-1;

        while(j>0){
            i = n-1;
            while(i>=0){
                row2[i] = row1[i] + row2[i+1];
                i--;
            }
            row1 = Arrays.copyOf(row2, row2.length);
            row2 = new int[n + 1];
            j--;
        }
        return row1[0];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3,7));
    }
}
