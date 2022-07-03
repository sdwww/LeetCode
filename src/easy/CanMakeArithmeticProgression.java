package easy;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 */
public class CanMakeArithmeticProgression {

    public static void main(String[] args) {
        CanMakeArithmeticProgression solution = new CanMakeArithmeticProgression();
        int[] arr = {1, 3, 2, 6, 5};
        System.out.println(solution.canMakeArithmeticProgression(arr));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int distannce = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != distannce) {
                return false;
            }
        }
        return true;
    }
}
