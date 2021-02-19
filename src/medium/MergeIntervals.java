package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 */
public class MergeIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {2, 4}, {1, 3}, {6, 7}};
        // [1,3],[2,6],[8,10],[15,18]
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merge = mergeIntervals.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[0].length; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] merge(int[][] intervals) {
        // 1.对区间列表进行排序,以左开始点排序
        Arrays.sort(intervals, Comparator.comparingInt((int[] x) -> x[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 2.如果区间不相连，将上一个区间放到结果集
            if (intervals[i][0] > intervals[i - 1][1]) {
                result.add(intervals[i - 1]);
            } else {
                // 3.否则合并两个区间
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }
        result.add(intervals[intervals.length - 1]);
        return result.toArray(new int[result.size()][2]);
    }
}
