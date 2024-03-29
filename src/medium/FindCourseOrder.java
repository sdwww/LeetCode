/**
 * @(#)FindCourseOrder.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 210. 课程表 II
 *
 * @author wangweiwei
 */
public class FindCourseOrder {

    public static void main(String[] args) {
        FindCourseOrder solution = new FindCourseOrder();
        int[] order = solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        for (int num : order) {
            System.out.println(num);
        }
    }

    // 时间复杂度O(n+m)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        // 入度
        int[] indegs = new int[numCourses];
        // 邻接表
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        // 构建入度表和邻接表
        for (int[] element : prerequisites) {
            edges.get(element[1]).add(element[0]);
            indegs[element[0]]++;
        }

        // 将入度为0节点的放入队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegs.length; i++) {
            if (indegs[i] == 0) {
                queue.offer(i);
            }
        }
        // 从队列中取出元素，将对应的入度减一，直到队列为空
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result.add(poll);
            for (Integer num : edges.get(poll)) {
                indegs[num]--;
                if (indegs[num] == 0) {
                    queue.offer(num);
                }
            }
        }
        if (result.size() == numCourses) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[0];
    }
}