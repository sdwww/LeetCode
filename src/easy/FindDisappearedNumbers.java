package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        FindDisappearedNumbers solution =new FindDisappearedNumbers();
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        disappearedNumbers.forEach(System.out::println);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
