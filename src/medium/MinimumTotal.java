package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class MinimumTotal {

    public static void main(String[] args) {
        MinimumTotal solution = new MinimumTotal();
        List<List<Integer>> triangle = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        System.out.println(solution.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        List<Integer> totalPre = triangle.get(0);
        List<Integer> total = triangle.get(0);
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < triangle.size(); j++) {
            List<Integer> list = triangle.get(j);
            total = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int a = (i == 0) ? Integer.MAX_VALUE : totalPre.get(i - 1);
                int b = (i == (list.size() - 1)) ? Integer.MAX_VALUE : totalPre.get(i);
                total.add(Math.min(a, b) + list.get(i));
            }
            totalPre = total;
        }
        for (int num : total) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
