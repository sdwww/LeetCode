package medium;

/**
 * 剑指 Offer 13. 机器人的运动范围
 */
public class MovingCount {
    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(2, 3, 1));
        System.out.println(movingCount.movingCount(2, 3, 0));
        System.out.println(movingCount.movingCount(100, 100, 20));

    }


    public int movingCount(int m, int n, int k) {
        boolean[][] canMove = new boolean[m][n];
        canMove[0][0] = true;
        int count = 1;
        int totalCount = 1;
        while (count > 0) {
            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canMoveThisTime(canMove, m, n, k, i, j)) {
                        canMove[i][j] = true;
                        count++;
                        totalCount++;
                    }
                }
            }
        }
        return totalCount;
    }

    private boolean canMoveThisTime(boolean[][] canMove, int m, int n, int k, int i, int j) {
        if (canMove[i][j]) {
            return false;
        }
        if (sumEachPos(i) + sumEachPos(j) > k) {
            return false;
        }
        boolean near = false;
        if (i > 0) {
            near = canMove[i - 1][j];
        }
//        if (i < m - 1) {
//            near |= canMove[i + 1][j];
//        }
        if (j > 0) {
            near |= canMove[i][j - 1];
        }
//        if (j < n - 1) {
//            near |= canMove[i][j + 1];
//        }
        return near;
    }

    private int sumEachPos(int num) {
        if (num == 100) {
            return 1;
        }
        if (num < 10) {
            return num;
        }
        return num / 10 + num % 10;
    }
}
