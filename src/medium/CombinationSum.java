package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] arr = {3, 2, 1};
        System.out.println(solution.combinationSum(arr, 5));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum(candidates, 0, 0, target, lists, new ArrayList<>());
        return lists;
    }

    public void combinationSum(int[] candidates, int sum, int index, int target, List<List<Integer>> lists, List<Integer> list) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> listCopy = new ArrayList<>(list);
            lists.add(listCopy);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, sum + candidates[i], i, target, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
