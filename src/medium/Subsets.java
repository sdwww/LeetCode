package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78-子集
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] array = {1, 2, 3, 4, 6};
//        System.out.println(solution.subsets(array));
        System.out.println(solution.subsets2(array));
    }

    public List<List<Integer>> subsets(int[] nums) {
        boolean[][] oneZeroArray = getSubsetOneZeroArray(nums.length);
        List<List<Integer>> lists = new ArrayList<>();
        for (boolean[] booleans : oneZeroArray) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < booleans.length; i++) {
                if (booleans[i]) {
                    arrayList.add(nums[i]);
                }
            }
            lists.add(arrayList);
        }
        return lists;
    }

    /**
     * 获取一个集合的子集合对应的01串
     *
     * @param setSize 集合大小
     * @return 一个集合的子集合对应的01串
     */
    private boolean[][] getSubsetOneZeroArray(int setSize) {
        int subsetSize = (int) Math.pow(2, setSize);
        boolean[][] oneZeroArray = new boolean[subsetSize][setSize];
        for (int i = 0; i < subsetSize; i++) {
            String binaryString = Integer.toBinaryString(i);
            for (int j = setSize - binaryString.length(); j < setSize; j++) {
                oneZeroArray[i][j] = "1".equals(binaryString.substring(j + binaryString.length() - setSize, j + binaryString.length() - setSize + 1));
            }
        }
        return oneZeroArray;
    }

    /**
     * 递归
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        subset(lists, 0, new ArrayList<>(), nums);
        return lists;
    }

    private void subset(List<List<Integer>> lists, int index, List<Integer> trace, int[] nums) {
        if (index == nums.length) {
            lists.add(trace);
            return;
        }
        ArrayList<Integer> uselessList = new ArrayList<>(trace);
        subset(lists, index + 1, uselessList, nums);
        ArrayList<Integer> useList = new ArrayList<>(trace);
        useList.add(nums[index]);
        subset(lists, index + 1, useList, nums);
    }
}
