package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class YanghuiTriangle {
    public static void main(String[] args) {
        YanghuiTriangle solution = new YanghuiTriangle();
        System.out.println(solution.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if ( j > 0 && j < i) {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                } else {
                    list.add(1);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
