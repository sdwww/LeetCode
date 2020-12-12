package medium;

import java.util.Arrays;

public class ClosestDivisors {

    public static void main(String[] args) {
        ClosestDivisors solution = new ClosestDivisors();
        Arrays.stream(solution.closestDivisors(999)).forEach(System.out::println);
    }

    public int[] closestDivisors(int num) {
        int[] nums = new int[2];
        int sqrt = (int) Math.sqrt(num + 2);
        while (sqrt > 0) {
            if ((num + 1) % sqrt == 0) {
                nums[0] = sqrt;
                nums[1] = (num + 1) / sqrt;
                break;
            }
            if ((num + 2) % sqrt == 0) {
                nums[0] = sqrt;
                nums[1] = (num + 2) / sqrt;
                break;
            }
            sqrt--;
        }
        return nums;
    }

    public int[] closestDivisors1(int num) {
        int[] nums = new int[2];
        int sqrt1 = (int) Math.sqrt(num + 1);
        while (sqrt1 > 0) {
            if ((num + 1) % sqrt1 == 0) {
                nums[0] = sqrt1;
                nums[1] = (num + 1) / sqrt1;
                break;
            }
            sqrt1--;
        }
        int sqrt2 = (int) Math.sqrt(num + 2);
        while (sqrt2 > 0) {
            if ((num + 2) % sqrt2 == 0) {
                if (sqrt2 > sqrt1) {
                    nums[0] = sqrt2;
                    nums[1] = (num + 2) / sqrt2;
                }
                break;
            }
            sqrt2--;
        }
        return nums;
    }
}
