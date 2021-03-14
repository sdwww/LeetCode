package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permute {

    public static void main(String[] args) {
        Permute solution = new Permute();
        // 123 213 312 132 231 321
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution.permute(arr));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 将array转换成list
        List<Integer> allList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            allList.add(nums[i]);
        }
        generate(lists, new ArrayList<>(), allList);
        return lists;
    }

    private void generate(List<List<Integer>> lists, List<Integer> tempList, List<Integer> allList) {
        if (tempList.size() == allList.size()) {
            lists.add(tempList);
            return;
        }
        // 剩余元素列表
        List<Integer> leftList = new ArrayList<>(allList);
        leftList.removeAll(tempList);
        for (Integer integer : leftList) {
            List<Integer> tempListNew = new ArrayList<>(tempList);
            tempListNew.add(integer);
            generate(lists, tempListNew, allList);
        }
    }
}
