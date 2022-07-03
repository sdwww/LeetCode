package medium;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 */
public class MinIncrementForUnique {

    public static void main(String[] args) {
        MinIncrementForUnique solution = new MinIncrementForUnique();
//        int[] arr = {3, 2, 1, 2, 1, 7};
        int[] arr = new int[40000];
        long startTime = System.currentTimeMillis();
        System.out.println(solution.minIncrementForUnique(arr));
        System.out.println("执行时间：" + (System.currentTimeMillis() - startTime));
    }

    public int minIncrementForUnique(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int differnce = A[i - 1] - A[i] + 1;
                count += differnce;
                A[i] += differnce;
            }
        }
        return count;
    }

}
