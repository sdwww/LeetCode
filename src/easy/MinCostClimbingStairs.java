package easy;

/**
 * @date 2020/8/9 18:57
 * Description:746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
//        int[] arr = {10, 15, 20};
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution.minCostClimbingStairs(arr));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] totalCost = new int[cost.length + 1];
        totalCost[0] = cost[0];
        totalCost[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            totalCost[i] = Math.min(totalCost[i - 1], totalCost[i - 2]) + cost[i];
        }
        return Math.min(totalCost[cost.length - 1], totalCost[cost.length - 2]);
    }
}
