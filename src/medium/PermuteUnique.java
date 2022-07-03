package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2020/8/9 15:04
 * Description:47. 全排列 II
 */
public class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique solution = new PermuteUnique();
        int[] arr = {1, 1, 1, 2};
        System.out.println(solution.permuteUnique(arr));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        generate(lists, new ArrayList<>(), nums, visited);
        return lists;
    }

    private void generate(List<List<Integer>> lists, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            lists.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 如果当前值和上一个值重复，应该从左往右递归，不能乱序
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            // 标准回溯写法
            temp.add(nums[i]);
            visited[i] = true;
            generate(lists, temp, nums, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
