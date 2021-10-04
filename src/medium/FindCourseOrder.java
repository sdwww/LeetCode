/**
 * @(#)FindCourseOrder.java, 10月 04, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();

        return null;
    }
}