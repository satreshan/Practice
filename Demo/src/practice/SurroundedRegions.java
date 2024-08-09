package practice;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = m > 0 ? board[0].length : 0;
        //iterate through the matrix and each 0 call dfs
        for(int i = 1 ; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                if(board[i][j] == 'O'){
                    dfs(board, i, j, m, n);
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j, int m, int n){
        if(i <= 0 || i >= m-1 || j <= 0 || j >= n-1 || board[i][j] == 'Y' || board[i][j] == 'X')
            return;
        else{
            board[i][j] = 'Y';
            dfs(board, i+1, j, m, n);
            dfs(board, i-1, j, m, n);
            dfs(board, i, j+1, m, n);
            dfs(board, i, j-1, m, n);
            board[i][j] = 'X';
        }
    }

    public static void main(String[] args) {
        char board[][] = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        new SurroundedRegions().solve(board);

        System.out.println(board);
    }
}
