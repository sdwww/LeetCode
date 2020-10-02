package medium;

/**
 * Copyright (C), 2018-2020 JD.COM All Right Reserved
 *
 * @author wangweiwei56
 * @date 2020/10/2 20:56
 * Description:343. 整数拆分
 */
public class IntegerBreak {

    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();
        System.out.println(solution.integerBreak(10));
        System.out.println(solution.integerBreak(6));

    }

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if(n==3){
            return 2;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        for (int i = 4; i <= n; i++) {
            nums[i] = Math.max(nums[i - 2] * 2, nums[i - 3] * 3);
        }
        return nums[n];
    }
}
