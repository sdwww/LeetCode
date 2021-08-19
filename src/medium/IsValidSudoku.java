package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 *
 * @author www
 */
public class IsValidSudoku {

    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        char[][] nums = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '6', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = isValidSudoku.isValidSudoku(nums);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        // 每一列不能重复
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }

        // 每一行不能重复
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.' && set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
        }

        // 每个3*3的正方形不能重复
        int[][] index = new int[][]{{0, 3, 0, 3}, {0, 3, 3, 6}, {0, 3, 6, 9},
                {3, 6, 0, 3}, {3, 6, 3, 6}, {3, 6, 6, 9},
                {6, 9, 0, 3}, {6, 9, 3, 6}, {6, 9, 6, 9}};
        for (int i = 0; i < index.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = index[i][0]; j < index[i][1]; j++) {
                for (int k = index[i][2]; k < index[i][3]; k++) {
                    if (board[j][k] != '.' && set.contains(board[j][k])) {
                        return false;
                    }
                    set.add(board[j][k]);
                }
            }
        }
        return true;
    }
}