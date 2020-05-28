/**
 * 70.爬楼梯
 */
public class ClimbStairs {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }
}

class Solution {
    public int climbStairs(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i- 2];
        }
        return array[n];
    }
}
