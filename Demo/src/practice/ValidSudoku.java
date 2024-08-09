package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set found = new HashSet();
        Map<String, String> m = new HashMap<>();
        int r = 0;
        int c = 0;
        for(r=0; r < 9; r++){
            for(c = 0; c< 9; c++){
                char ch = board[r][c];
                if(ch == '.') continue;
                String rc = "r" + r + ch;
                String cc = "c" + c + ch;
                String b = "b" + r/3 + "-" + c/3 + ch;
                if(!found.add(rc) || !found.add(cc) || !found.add(b))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new ValidSudoku().isValidSudoku(board));
        //IntStream.of(1,2,3).sum();
    }
}
