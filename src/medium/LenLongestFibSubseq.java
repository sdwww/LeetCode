package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 873. 最长的斐波那契子序列的长度
 */
public class LenLongestFibSubseq {

    public static void main(String[] args) {
        LenLongestFibSubseq solution = new LenLongestFibSubseq();
        int[] arr = {1, 3, 7, 11, 12, 14, 23};
//        int[] arr = {1, 2, 3, 5, 8, 13, 21};
        System.out.println(solution.lenLongestFibSubseq(arr));
    }

    public int lenLongestFibSubseq(int[] A) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int length = 2;
                int x = A[i], y = A[j];
                while (set.contains(x + y)) {
                    int temp = y;
                    y = temp + x;
                    x = temp;
                    length++;
                    max = Math.max(max, length);
                }
            }
        }
        return max > 2 ? max : 0;
    }

}
