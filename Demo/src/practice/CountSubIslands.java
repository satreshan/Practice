package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


class CountSubIslands {

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object p){
            if (p == this) {
                return true;
            }
            if (!(p instanceof Pair)) {
                return false;
            }
            Pair pp = (Pair) p;
            return this.x == pp.x && this.y == pp.y;
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        List<Set<Pair>> grid1Islands = new ArrayList<>();
        List<Set<Pair>> grid2Islands = new ArrayList<>();
        for(int i =0; i<grid1.length; i++){
            for(int j =0; j< grid1[0].length; j++){
                if(grid1[i][j] == 1){
                    Set<Pair> setPair = new HashSet<>();
                    findIslands(grid1, setPair, i, j);
                    grid1Islands.add(setPair);
                }
                if(grid2[i][j] == 1){
                    Set<Pair> setPair = new HashSet<>();
                    findIslands(grid2, setPair, i, j);
                    grid2Islands.add(setPair);
                }
            }
        }

        int count = 0;
        for(Set<Pair> subIsland : grid2Islands){
            for(Set<Pair> island : grid1Islands){
                if(island.containsAll(subIsland)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private void findIslands(int[][] grid, Set<Pair> setIslandPair, int i, int j){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0)
            return;
        else{
            grid[i][j] = 0;
            setIslandPair.add(new Pair(i, j));
            findIslands(grid, setIslandPair, i+1, j);
            findIslands(grid, setIslandPair, i-1, j);
            findIslands(grid, setIslandPair, i, j+1);
            findIslands(grid, setIslandPair, i, j-1);
        }
    }

    public static void main(String[] args) {
        //int[] d = new int[]{1,2};
        //Queue<Integer> q = new LinkedList<>();
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(new CountSubIslands().countSubIslands(grid1, grid2));
    }
}
