/**
 * @(#)CanFinishCourse.java, 10月 05, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 *
 * @author wangweiwei
 */
public class CanFinishCourse {

    public static void main(String[] args) {
        CanFinishCourse solution = new CanFinishCourse();
        boolean b = solution.canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(b);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
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
            count++;
            for (Integer num : edges.get(poll)) {
                indegs[num]--;
                if (indegs[num] == 0) {
                    queue.offer(num);
                }
            }
        }
        return count == numCourses;
    }
}