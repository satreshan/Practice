package practice.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestBridge {
    int[][] direction = {{0,1},{0,-1}, {1,0},{-1,0}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<n ; i ++){
            for(int j = 0;j <n ; j++){
                if(grid[i][j] == 1){
                    dfs(grid, queue, i, j );
                    return bfs(grid, queue);
                }
            }
        }
        return res;

    }

    boolean invalid(int i, int j, int n){
        return i < 0 || j <0 || i >= n || j >= n;
    }

    void dfs(int[][] grid, Queue<int[]> queue, int i, int j){
        if(invalid(i, j , grid.length) || grid[i][j] == -1 || grid[i][j] == 0)
            return;
        else{
            grid[i][j] = -1;
            queue.add(new int[]{i,j});
            dfs(grid, queue, i+1, j);
            dfs(grid, queue, i-1, j);
            dfs(grid, queue, i, j+1);
            dfs(grid, queue, i, j-1);
        }
    }

    int bfs(int[][] grid, Queue<int[]> queue){
        int res = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                int[] element = queue.remove();
                for(int[] neighbour : direction){
                    int ni = element[0] + neighbour[0];
                    int nj = element[1] + neighbour[1];
                    if(invalid(ni, nj, grid.length) || grid[ni][nj] == -1)
                        continue;
                    if(grid[ni][nj] == 0){
                        grid[ni][nj] = -1;
                        queue.add(new int[]{ni, nj});
                    }
                    if(grid[ni][nj] == 1){
                        return res;
                    }
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(new ShortestBridge().shortestBridge(grid));
    }
}
