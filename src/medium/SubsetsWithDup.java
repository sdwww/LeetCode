package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 */
public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup solution = new SubsetsWithDup();
        int[] arr = {1, 2, 1, 0};
        solution.subsetsWithDup(arr).forEach(System.out::println);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        search(nums, lists, 0, new ArrayList<>());
        return lists;
    }

    private void search(int[] nums, List<List<Integer>> lists, int index, List<Integer> list) {
        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            search(nums, lists, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
