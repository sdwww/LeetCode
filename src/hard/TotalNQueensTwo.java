package hard;

/**
 * 52. N皇后 II
 */
public class TotalNQueensTwo {

    private int count = 0;


    public static void main(String[] args) {
        TotalNQueensTwo solution = new TotalNQueensTwo();
        System.out.println(solution.totalNQueens(8));
    }

    public int totalNQueens(int n) {
        int[] arr = new int[n];
        check(0, n, arr);
        return count;
    }

    private void check(int rowNum, int n, int[] arr) {
        if (rowNum >= n) {
            count++;
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
}
