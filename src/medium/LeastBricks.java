/**
 * @(#)LeastBricks.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. 砖墙
 *
 * @author wangweiwei
 */
public class LeastBricks {

    public static void main(String[] args) {

        List<Integer> list1 = Lists.newArrayList(1, 2, 2, 1);
        List<Integer> list2 = Lists.newArrayList(3, 1, 2);
        List<Integer> list3 = Lists.newArrayList(1, 3, 2);
        List<Integer> list4 = Lists.newArrayList(2, 4);
        List<Integer> list5 = Lists.newArrayList(3, 1, 2);
        List<Integer> list6 = Lists.newArrayList(1, 3, 1, 1);
        List<List<Integer>> lists = Lists.newArrayList(list1, list2, list3, list4, list5, list6);

        LeastBricks solution = new LeastBricks();
        int i = solution.leastBricks(lists);
        System.out.println(i);

    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int result = wall.size();
        for (List<Integer> list : wall) {
            int sum = 0;
            // 排除最后你一块
            for (int j = 0; j < list.size() - 1; j++) {
                sum += list.get(j);
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        for (Integer sum : sumMap.keySet()) {
            result = Math.min(result, wall.size() - sumMap.get(sum));
        }
        return result;
    }
}