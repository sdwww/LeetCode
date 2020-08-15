package medium;

/**
 * Copyright (C), 2018-2020 JD.COM All Right Reserved
 *
 * @author wangweiwei56
 * @date 2020/8/15 16:09
 * Description:287. 寻找重复数
 */
public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate solution = new FindDuplicate();
        int[] arr = {3, 2, 1, 3, 4, 5};
        System.out.println(solution.findDuplicate(arr));
    }

    public int findDuplicate1(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (arr[num] > 0) {
                return num;
            } else {
                arr[num] = 1;
            }
        }
        return 0;
    }

    public int findDuplicate(int[] nums) {
        int fast = nums[nums[nums[0]]];
        int slow = nums[nums[0]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int num1 = fast;
        int num2 = nums[0];
        while (num1 != num2) {
            num1 = nums[num1];
            num2 = nums[num2];
        }
        return num1;
    }
}
