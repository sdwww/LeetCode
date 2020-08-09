package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2020 JD.COM All Right Reserved
 *
 * @author wangweiwei56
 * @date 2020/8/9 14:20
 * Description:77. 组合
 */
public class Combine {

    public static void main(String[] args) {
        Combine solution = new Combine();
        System.out.println(solution.combine(20, 10));
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int temp = i;
            List<Integer> list = new ArrayList<>();
            list.add(i);
            add(lists, n, k, list, temp);
        }
        return lists;
    }

    private void add(List<List<Integer>> lists, int n, int k, List<Integer> list, int index) {
        // 剪枝
        if (index > n || list.size() < k - n + index) {
            return;
        }
        if (list.size() == k) {
            lists.add(list);
            return;
        }
        for (int i = index + 1; i <= n; i++) {
            List<Integer> listTemp = new ArrayList<>(list);
            listTemp.add(i);
            add(lists, n, k, listTemp, i);
        }
    }
}
