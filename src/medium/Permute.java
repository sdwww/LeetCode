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
        int[] arr = {1, 2, 3,4,5,6,7,8};
        System.out.println(solution.permute(arr));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> allList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            allList.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            generate(lists, list, allList);
        }
        return lists;
    }

    private void generate(List<List<Integer>> lists, List<Integer> list, List<Integer> allList) {
        if (list.size() == allList.size()) {
            lists.add(list);
            return;
        }
        List<Integer> leftList = new ArrayList<>(allList);
        leftList.removeAll(list);
        for (Integer integer : leftList) {
            List<Integer> listTemp = new ArrayList<>(list);
            listTemp.add(integer);
            generate(lists, listTemp, allList);
        }

    }


}
