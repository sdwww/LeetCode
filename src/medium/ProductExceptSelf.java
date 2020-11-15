package medium;

import java.util.Arrays;

/**
 * @date 2020/10/4 9:29
 * Description:238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();
        int[] arr = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    public int[] productExceptSelf(int[] nums) {
        int p = 1, q = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= q;
            q *= nums[i];
        }
        return result;
    }

}
