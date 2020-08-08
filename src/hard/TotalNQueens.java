package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 */
public class TotalNQueens {

    private List<List<String>> lists = new ArrayList<>();

    public static void main(String[] args) {
        TotalNQueens solution = new TotalNQueens();
        System.out.println(solution.solveNQueens(8));
    }

    public List<List<String>> solveNQueens(int n) {
        int[] arr = new int[n];
        check(0, n, arr);
        return lists;
    }

    private void check(int rowNum, int n, int[] arr) {
        if (rowNum >= n) {
            add(arr);
        }
        for (int i = 0; i < n; i++) {
            if (judge(rowNum, i, arr)) {
                arr[rowNum] = i;
                check(rowNum + 1, n, arr);
            }
        }
    }

    private boolean judge(int rowNum, int value, int[] arr) {
        for (int i = 0; i < rowNum; i++) {
            if (arr[i] == value || Math.abs(arr[i] - value) == Math.abs(i - rowNum)) {
                return false;
            }
        }
        return true;
    }

    private void add(int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (j == arr[i]) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            list.add(stringBuilder.toString());
        }
        lists.add(list);
    }
}
