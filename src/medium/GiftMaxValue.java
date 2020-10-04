package medium;

/**
 * @date 2020/10/3 14:59
 * Description:剑指 Offer 47. 礼物的最大价值
 */
public class GiftMaxValue {

    public static void main(String[] args) {
        GiftMaxValue solution = new GiftMaxValue();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        int[][] maxValues = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                maxValues[i][j] = Math.max(maxValues[i - 1][j], maxValues[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return maxValues[grid.length][grid[0].length];
    }
}
