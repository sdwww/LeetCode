package medium;

import java.util.Arrays;

/**
 * @date 2020/10/4 9:29
 * Description:238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();
        int[] arr = {1, 2, 3};
        System.out.println((double) 2 / 3);
        Arrays.stream(solution.productExceptSelf(arr)).forEach(System.out::print);
    }

    public int[] productExceptSelf(int[] nums) {
        int p = 1, q = 1;
        int[] result = new int[nums.length];
        // p正序乘以每一个数字
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }
        // p倒序乘以每一个数字
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= q;
            q *= nums[i];
        }
        return result;
    }
}
