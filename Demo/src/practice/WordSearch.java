package practice;

import java.util.Arrays;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean found = false;
        for(int i = 0; i< m; i++){
            for(int j=0;j<n; j++){
                if(board[i][j] == word.charAt(0))
                    found = dfs(board, word, i, j, 0);  //if first character matches and fail the subsequent seq to
                // match....continue search
                if(found == true)
                    return found; //if found return immediately... i.e if dfs return true
            }
        }
        return found;
    }

    boolean dfs(char[][] board, String word, int i, int j, int k){
        boolean found = false;
        if( k == word.length()){
            return true;
        }
        if(i<0 || j< 0 || i >=board.length || j >=board[0].length || board[i][j] != word.charAt(k)){
            return false;
        }
        char currChar = board[i][j];
        board[i][j] = ' ';
        found = dfs(board, word, i, j-1, k+1) ||
                dfs(board, word, i-1, j, k+1) ||
                dfs(board, word, i, j+1, k+1) ||
                dfs(board, word, i+1, j, k+1);
        board[i][j] = currChar;


        return found;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(matrix, word));
    }
}
