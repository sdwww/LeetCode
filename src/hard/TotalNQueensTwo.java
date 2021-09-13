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

    /**
     *
     * @param currentRowNum 当前行数
     * @param n 总个数
     * @param arr 维护的数组
     */
    private void check(int currentRowNum, int n, int[] arr) {
        if (currentRowNum >= n) {
            count++;
        }
        for (int i = 0; i < n; i++) {
            if (judge(currentRowNum, i, arr)) {
                // 不需要清除数据，因为后面的遍历会覆盖
                arr[currentRowNum] = i;
                check(currentRowNum + 1, n, arr);
            }
        }
    }

    /**
     * 判断某个位置是否可以放置棋子
     * @param currentRowNum 当前行数
     * @param currentValue 当前值
     * @param arr 维护的数组
     * @return 是否可行
     */
    private boolean judge(int currentRowNum, int currentValue, int[] arr) {
        for (int i = 0; i < currentRowNum; i++) {
            if (arr[i] == currentValue || Math.abs(arr[i] - currentValue) == Math.abs(i - currentRowNum)) {
                return false;
            }
        }
        return true;
    }
}
