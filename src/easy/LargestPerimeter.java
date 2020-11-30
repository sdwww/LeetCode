package easy;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 */
public class LargestPerimeter {

    public static void main(String[] args) {
        LargestPerimeter largestPerimeter = new LargestPerimeter();
        int[] array = {3,6,2,3};
//        int[] array = {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(largestPerimeter.largestPerimeter(array));
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}

