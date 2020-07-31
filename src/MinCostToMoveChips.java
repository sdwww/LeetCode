/**
 * 1217. 玩筹码
 */
public class MinCostToMoveChips {

    public static void main(String[] args) {
        MinCostToMoveChips solution = new MinCostToMoveChips();
        int[] arr = {2, 3, 4, 5, 7, 4, 4};
        System.out.println(solution.minCostToMoveChips(arr));

    }

    public int minCostToMoveChips(int[] chips) {
        int singleCount = 0;
        int doubleCount = 0;
        for (int i : chips) {
            if (i % 2 == 1) {
                singleCount++;
            } else {
                doubleCount++;
            }
        }
        return singleCount > doubleCount ? doubleCount : singleCount;
    }
}
